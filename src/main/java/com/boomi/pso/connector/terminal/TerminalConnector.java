package com.boomi.pso.connector.terminal;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.Browser;
import com.boomi.connector.api.Operation;
import com.boomi.connector.api.OperationContext;
import com.boomi.pso.connector.terminal.operation.TerminalExecuteOperation;
import com.boomi.connector.util.BaseConnector;

public class TerminalConnector extends BaseConnector {

    @Override
    public Browser createBrowser(BrowseContext browseContext) {
        return null;
    }

    @Override
    protected Operation createExecuteOperation(OperationContext context) {
        return new TerminalExecuteOperation(context);
    };


}
