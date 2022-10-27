# JSON to BSON Converter

Simple Java / Maven program to convert MongoDB JSON String to MongoDB BSON String.
You need Java 11 and Maven to run it.

Simply put the MongoDB JSON Array into `./src/main/resources/jsonFile.json` file
  
then run the program by executing the main method from: `./src/main/java/Service/Main.java` class,
  
then get the corresponding BSON Array from `./bsonFile.txt` file.
  
It will also print the output BSON Array.

Example: it will convert this:
  
```
[
{
"_id": {"$oid": "5fb68c8d51e26038ff998d01"},
"updatedBy": "userOne",
"updatedOn": {"$date": "2022-03-09T12:03:57.002Z"}
},
{
"_id": {"$oid": "5fb68c8d51e26038ff998d02"},
"updatedBy": "userTwo",
"updatedOn": {"$date": "2020-12-16T13:12:17.301Z"}
}
]
```
  
into this:
  
```
[
{
"_id": ObjectId("5fb68c8d51e26038ff998d01"),
"updatedBy": "userOne",
"updatedOn": ISODate("2022-03-09T12:03:57.002Z")
},
{
"_id": ObjectId("5fb68c8d51e26038ff998d02"),
"updatedBy": "userTwo",
"updatedOn": ISODate("2020-12-16T13:12:17.301Z")
}
]
```
