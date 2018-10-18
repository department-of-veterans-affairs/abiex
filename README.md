## Index extraction system

If using the system, please cite:

  Alba PR, Duvall SL, Norvell DC, Moore KP, Czerniecki JM, Patterson OV. **Ankle Brachial Index Extraction System**. In: AMIA Annu Symp Proc. 2018. 

The system is based on Leo architecture extending UIMA AS.  For more info on Leo see [ http://department-of-veterans-affairs.github.io/Leo/userguide.html ]
To use the system:
  1. Follow the instructions to install and configure UIMA AS Steps 2.1-2.9 on page [ http://department-of-veterans-affairs.github.io/Leo/userguide.html#/a2_Installation_and_Configuration_of_Leo-Example ] .
  2. Start UIMA AS Broker.

Open the code in IDE of your preference. We recommend using IntelliJ Community version [ https://www.jetbrains.com/idea/download ]

To run AbiService, right click on src/main/java/gov/va/vinci/abi/AbiService and select Run AbiService.main()

To run AbiClient to read from files and write to xmi, right click on src/main/java/gov/va/vinci/abi/AbiClient and select Run AbiClient.main()

To run AbiService to read from other sources and write to a different output, readers and listeners have to be configured and then specified as Program arguments.
If reading from a database, you might need to add Djava.library.path VM configuration

Client VM options:

    -Djava.library.path="lib;"
    -Dlog4j.configuration='config/log4j.properties'

Client Program arguments:

    -clientConfigFile=config/ClientConfig.groovy

    -readerConfigFile=config/readers/FileCollectionReaderConfig.groovy
    -readerConfigFile=config/readers/DatabaseCollectionReaderConfig.groovy
    -readerConfigFile=config/readers/SQLServerPagedDatabaseCollectionReaderConfig.groovy
    -readerConfigFile=config/readers/BatchDatabaseCollectionReaderConfig.groovy

    -listenerConfigFile=config/listeners/SimpleXmiListenerConfig.groovy
    -listenerConfigFile=config/listeners/SimpleCsvListenerConfig.groovy
    -listenerConfigFile=config/listeners/DatabaseListenerConfig.groovy
    -listenerConfigFile=config/listeners/KnowtatorListenerConfig.groovy
    -listenerConfigFile=config/listeners/AuCompareSummaryListenerConfig.groovy
    -listenerConfigFile=config/listeners/AuCompareCsvListenerConfig.groovy
