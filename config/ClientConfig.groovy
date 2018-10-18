/*
 * The UIMA AS Broker url that is coordinating requests.
 */
brokerURL						="tcp://localhost:61616";
/*
 * The endpoint name of the UIMA AS service to use for processing. The service will be
 * registered with the broker as this service name. Clients use the broker/service combination
 * to connect to this service.
 */
endpoint                        = "abi"
casPoolSize                     = 10
