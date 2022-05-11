GO TO THE src/main/resources/application.properties
Update/Add the username and password of the Database
Please use the Postgres DB.

OPEN THE POSTMAN AND USE THE FOLLOWING METHODS

lIST ALL EMPLOYEE : localhost:8100/getAllEmployee
GET EMPLOYEE BY ID : localhost:8100/getById/2
ADD EMPLOYEE: localhost:8100/addEmployee
Set content type as application/json
{
    "empId": 5,
    "empName": "Sumit",
    "salary": 240000,
    "deptId": 32,
    "role": "Digital Marketer"
}
UPDATE EMPLOYEE : localhost:8100/updateEmployee
Keep the empId as it is for the one which we have to update
Set content type as application/json
{
    "empId": 5,
    "empName": "Sumit",
    "salary": 240000,
    "deptId": 32,
    "role": "Digital Marketer"
}
DELETE EMPLOYEE BY ID : localhost:8100/deleteById/5

Status code as 2xx indicates as successful operations performed.