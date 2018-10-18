/**
 * The UIMA AS Broker url that is coordinating requests.
 */
brokerURL = "tcp://localhost:61616"

/**
 * The endpoint name of the UIMA AS service to use for processing. The service will be
 * registered with the broker as this service name. Clients use the broker/service combination
 * to connect to this service.
 */
endpoint = "abi"

createTypes=false

/** Tell the service to persist the descriptors that are generated, deletes them by default **/
deleteOnExit = true

if(!deleteOnExit) descriptorDirectory = "config/desc"

/** Additional service configurations  **/
casPoolSize = 10