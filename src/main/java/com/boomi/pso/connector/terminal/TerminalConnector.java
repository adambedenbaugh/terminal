package com.boomi.pso.connector.terminal;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.Browser;
import com.boomi.connector.api.Operation;
import com.boomi.connector.api.OperationContext;
import com.boomi.pso.connector.terminal.operation.TerminalExecuteOperation;

public class TerminalConnector {

    @Override
    public Browser createBrowser(BrowseContext browseContext) {
        return null;
    }

    @Override
    protected Operation createExecuteOperation(OperationContext context) {
        return new TerminalExecuteOperation(context);
    };


}
