新增部門 POST : /depts  ex: { "deptName" : "dept1" }

更新部門 PUT : /depts  ex: { "deptID":"3", "deptName" : "dept2", "deptOldName" : "dept1" }

刪除部門 DELETE : /depts/{deptID} ex: /dept/1

取得部門訊息 GET : /depts 

新增員工 POST : /emps  ex: { "empName" : "Brayden", "deptID" : "1", "gender" : "male", "empPhone" : "16138", "address" : "BU9", "age" : 30 }

更新員工 PUT : /emps  ex: { "empID":"2", "empName" : "Brayden", "deptID" : "1", "gender" : "male", "empPhone" : "16138", "address" : "BU10", "age" : 30 }

刪除員工 DELETE : /emps/{empID}  ex: /emps/2

取得員工訊息 GET : /emps  ex: { "empName" : "Brayden", "page" : 1, "size" : 10 }
