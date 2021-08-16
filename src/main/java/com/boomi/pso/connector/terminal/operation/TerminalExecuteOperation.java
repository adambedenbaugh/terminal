package com.boomi.pso.connector.terminal.operation;

import com.boomi.connector.api.*;
import com.boomi.connector.util.BaseUpdateOperation;
import com.boomi.pso.connector.terminal.util.StringUtil;


public class TerminalExecuteOperation extends BaseUpdateOperation {

    private static final String RESPONSE_SUCCESS = "OK";
    private static final String RESPONSE_FAIL_ERROR = "ERROR";

    public TerminalExecuteOperation(OperationContext context) {
        super(context);
    }

    @Override
    protected void executeUpdate(UpdateRequest updateRequest, OperationResponse operationResponse) {

        for (ObjectData objectData : updateRequest) {
            try {
                String command = getCommand(objectData);
                operationResponse.getLogger().info("Command executed: " + command);

                if (StringUtil.isNullOrEmpty(command)) {
                    operationResponse.addErrorResult(objectData, OperationStatus.APPLICATION_ERROR, "NO_COMMAND",
                            "Command to Execute must be set within Set Property shape before the Terminal connector.",
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

