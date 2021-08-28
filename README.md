# Terminal Connector

## Purpose

The Terminal Connector will execute a command and return data from standard output into the data flow. This is 
helpful when the output of a command is used for a subsequent step within the integration.

The connector and operation require no setup. A new connector and operation does need to be created. It is 
recommended to enabling 
tracked fields. The document tracking direction can be changed to display either input or output data 
within process reporting. 


## Getting Started

Installation of a custom connector for Dell Boomi is relatively simple, but it will require Developer privileges to
upload
and release the connector files.

### Download the latest release

Download the latest Terminal Connector release from the [Releases](https://github.
com/adambedenbaugh/terminal/releases) page.

You should now have a zip file that contains the following files:

* terminal-\<version>--car.zip
* connector-descriptor.xml

### Create a Boomi Connector Group
Add a custom connector group to your Boomi account by following the instructions described in the Boomi documentation located here: https://help.boomi.com/bundle/connectors/page/t-atm-Adding_a_connector_group.html

### Upload the connector
Using the files that you extracted from the release download, upload the connector to the new connector group by following the instructions described in the Boomi documentation located here: https://help.boomi.com/bundle/connectors/page/t-atm-Adding_a_version_to_a_connector_group.html

### Upgrading the connector version
You can upgrade your Terminal Connector version by clicking the "Add Version" button in your existing
Terminal Connector connector group.

### Using The Connector
Once you install the connector to your account, you can begin using it like any other application connector.

### How to User the Connector within Boomi

![Process Overview](resources/TerminalProcessOverview.png?raw=true)


![Command to Execute within a Message Shape](resources/CommandToExecute.png?raw=true)

The process begins by putting the command to execute within a message shape. Each document going into the connector 
should be one command. An error will occur if two commands tried to be executed. The above message shape will execute 
a curl command that will return three random sentences.

![Terminal Connection](resources/TerminalConnection.png?raw=true)

A connection must be created but there is no configuration needed.

![Terminal Operation](resources/TerminalOperation.png?raw=true)

There are two configurations within the operation. The first configuration is the tracked document flow, which will 
allow you to view the incoming or outgoing message within Process Reporting. The second configuration is how the 
connector should error. The error can be caught at the connector level or can be caught after the connector with a 
decision shape.

![Standard Output Written to a Document](resources/DocumentOutput.png?raw=true)

