# This repo is created to make a custom presentaion schedule. When you want to make a schedule with your registered prenstation as daily. This app can help you to create daily schedule and it can handle start date, end date, lunch break etc.

#application.properties
- This application is going to start on 8080 default port.
- H2 embeded database is used to storage the datas.
- You can access H2-console via this link. http://localhost:8080/h2-console
- ![resim](https://user-images.githubusercontent.com/7984679/151786330-ed2dbf8b-22e2-4378-b78f-4e00b34a3929.png)

- If you want to add networking day, you need to set "true" for networkinh_day. When time is avaiable..
![resim](https://user-images.githubusercontent.com/7984679/151785683-63e4b2b0-877f-4a95-a2de-dd9fbd599c89.png)

#Using steps..
-Adding new presentation and listing the presentations that you have added.
![resim](https://user-images.githubusercontent.com/7984679/151786547-879fe7a5-2d9d-468b-a237-86d33e58480e.png)

- Load test data .

![resim](https://user-images.githubusercontent.com/7984679/151786847-fc2a9b80-c337-4b5b-b996-eb1ce896e353.png)

- Calculate the Track days.. (networking=true by default)
- ![resim](https://user-images.githubusercontent.com/7984679/151787023-1e6af836-4b88-40ad-9e50-369b17096009.png)

Also you can add meeting request with using POST http request as below:
<img width="652" alt="image" src="https://github.com/trademkose/meeting-scheduler/assets/7984679/c4bef599-0412-40c8-9667-eb8569c6467f">


#UNIT TEST
-JUNIT is used for Unit tests.
- All tests are passed..
- ![resim](https://user-images.githubusercontent.com/7984679/151786242-aa2fedd9-a579-4690-9014-7289995622ba.png)

  
unit test coverage.

![image](https://github.com/trademkose/meeting-scheduler/assets/7984679/6a5b5805-28e6-46fa-a4b1-d5f66f3c29be)



