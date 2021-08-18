#Terminal Connector

##Purpose

The Terminal Connector will execute a command and return data from standard output into the data flow. This can be 
helpful when the output of a command is required for the integration.

The connector and operation require no setup. A new connector and operation does need to be created. It is 
recommended to enabling 
tracked fields. The document tracking direction can be changed to display either input or output data 
within process reporting. 


## Getting Started

Installation of a custom connector for Dell Boomi is relatively simple, but it will require Developer privileges to
upload
and release the connector files.

### Download the latest release

Download the latest Document Tracker Connector release from the [Releases](https://github.com/adambedenbaugh/document-tracker-connector/releases) page.

You should now have the following files:

* document-tracker-connector-\<version>--car.zip
* connector-descriptor.xml

### Create a Boomi Connector Group
Add a custom connector group to your Boomi account by following the instructions described in the Boomi documentation located here: https://help.boomi.com/bundle/connectors/page/t-atm-Adding_a_connector_group.html

### Upload the connector
Using the files that you extracted from the release download, upload the connector to the new connector group by following the instructions described in the Boomi documentation located here: https://help.boomi.com/bundle/connectors/page/t-atm-Adding_a_version_to_a_connector_group.html

### Upgrading the connector version
You can upgrade your Document Tracker Connector version by clicking the "Add Version" button in your existing
Document Tracker Connector connector group.

### Using The Connector
Once you install the connector to your account, you can begin using it like any other application connector.



##Example Use Cases:

* Applying document tracking anywhere in the process.  This is especially useful if all the operations are batch.  This connector could be put in line at some point where the documents are split, recording the record id's per document in process reporting and searching by tracked fields.
* Ability to retrieve documents anywhere in the process from the documents API.  This could be particularly useful for test harness processes and test assertion.
* Ability to record un-truncated error results or to process reporting or recording documents at specific steps for troubleshooting.  Notify and exception shapes would logically be used, but are truncated at 10K characters.  The return documents shape can accomplish this, but is not usable in webservice processes since this shape is functional.