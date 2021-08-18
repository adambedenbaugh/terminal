package com.boomi.pso.connector.terminal.operation;

import com.boomi.connector.api.*;
import com.boomi.connector.util.BaseUpdateOperation;
import com.boomi.pso.connector.terminal.util.StringUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


public class TerminalExecuteOperation extends BaseUpdateOperation {

    private static final String RESPONSE_SUCCESS = "OK";
    private static final String RESPONSE_FAIL_ERROR = "ERROR";

    public TerminalExecuteOperation(OperationContext context) {
        super(context);
    }

    @Override
    protected void executeUpdate(UpdateRequest updateRequest, OperationResponse operationResponse) {

        for (ObjectData objectData : updateRequest) {

            //String command = getCommand(objectData);

            // TODO: This works but would rather use dynamic properties
            InputStream is = objectData.getData();
            String command = new BufferedReader(
                    new InputStreamReader(is, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            operationResponse.getLogger().info("Command executed: " + command);

            try {
                if (StringUtil.isNullOrEmpty(command)) {
                    System.out.println("hello");
                    operationResponse.addErrorResult(objectData, OperationStatus.APPLICATION_ERROR, "NO_COMMAND",
                            "The command to execute must be set within a message shape before the Terminal connector.",
                            null);
                } else {
                    Process process = Runtime.getRuntime().exec(command);
                    operationResponse.addResult(objectData, OperationStatus.SUCCESS, RESPONSE_SUCCESS,
                            RESPONSE_SUCCESS,
                            PayloadUtil.toPayload(process.getInputStream()));
                }

            } catch (Exception e) {
                operationResponse.addErrorResult(objectData, OperationStatus.FAILURE, RESPONSE_FAIL_ERROR, e.getMessage(), e);
                return;
            }
        }
    }

    private String getCommand(ObjectData objectData) {
        String command = objectData.getDynamicProperties().get("command");
        if (command == null || command.length() == 0) {
            return null;
        }
        return command;
    }

}

