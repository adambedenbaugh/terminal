package com.boomi.pso.connector.terminal;

import com.boomi.connector.api.OperationType;
import com.boomi.connector.testutil.ConnectorTester;
import com.boomi.connector.testutil.SimpleOperationResult;
import com.boomi.connector.testutil.SimpleTrackedData;
import org.junit.Test;
import java.util.*;


public class TestTerminalConnector {


    @Test
    public void testTerminalExecuteOperation() {
        long start = System.currentTimeMillis();

        TerminalConnector connector = new TerminalConnector();
        ConnectorTester tester = new ConnectorTester(connector);

        Map<String, Object> connProps = new HashMap<>();
        Map<String, Object> opProps = new HashMap<>();
        String objectTypeId = null;

        Map<String,String> dynamicProps = new HashMap<>();
        dynamicProps.put("command", "ipconfig");

        tester.setOperationContext(OperationType.EXECUTE, connProps, opProps, objectTypeId, null);

        SimpleTrackedData simpleTrackedData = new SimpleTrackedData(0,null,null,dynamicProps);
        List<SimpleTrackedData> simpleTrackedDataList = new ArrayList<>();
        simpleTrackedDataList.add(simpleTrackedData);

        List<SimpleOperationResult> actual = tester.executeExecuteOperationWithTrackedData(simpleTrackedDataList);
        System.out.println(actual);

        System.out.println("Total Time " + (System.currentTimeMillis() - start) + "ms");
    }
}