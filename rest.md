###REST Principles
- based on JSON payload
- using http protocol

###HTTP codes family
-1xx - processing in progress
-2xx - success
-3xx - redirect
-4xx - client's errors
-5xx - server's errors

###Http exchange message consists of:
- request
    - url
    - headers
    - body
- response
    - status code
    - headers
    - body

###CRUD over Http (Create/Read/Update/Delete)
- read data
  - Get method
- create data
  - Post method
- delete data
  - DELETE data
- update data
  - PUT method - for replacing data
  - PATCH method - for partial update

- urls - good practise(Playing with person) 
- we need to treat items like hierarchical collection
  - read
    - whole collection: /persons - with GET
    - one item: /persons/{id} - with GET, eg. persons/1 etc
  - create
    - url: /persons - with POST
    - payload put inside request body
  - delete
    - url: /persons/{id} - with Delete, eg. persons/1 etc
    - no content in request
  - update
    - url: /persons/{id} - with PUT, eg. persons/1 - replace object
    - url: /persons/{id} - with PATCH, eg. persons/1 - partial update
