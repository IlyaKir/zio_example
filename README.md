Example of my code extracted from the rest of the project logic from my last job for demonstration purposes. Main logic is in the `report_main` module

Technologies that I used to provide solution:
ZIO 1.0, ZLayers, ZIOMagic, ZManaged, ZIOFibers, ZIOSemaphors, ZIOActors, ZIOCaliban (GraphQL), S3 (MinIO), Apache POI, JWT, CharDetector, ZIOJson, ZIOTest

Note: there is no possibility to check the full operation of the service, as the operation depends on other services and input data (zip archive)

I had a task to implement background processing of data from zip-archive
Very short description of zip-archive and task:
- documents (just files, for example, `pdf`)  
- `.doc` file containing metadata about documents
- `.excel` file containing:     
    - object types that had to be mapped to existing ones from `mainApiService` before objects could be created
    - information about objects (names, metadata, properties, links to other objects, etc.) that had to be created in `mainApiService`
    - paths of documents that I had to send to the `documentProcessingService` and then link processed documents to objects in `mainApiService`

Usage:
- run application: `docker-compose up`
- run tests: `sbt test` (they rely on mocked data and services)
