$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/E_Personal/LearnigJ2EE/RestAPI_U_BDD/src/test/java/features/Maveric.feature");
formatter.feature({
  "line": 1,
  "name": "Testing some examples on RESREQ",
  "description": "",
  "id": "testing-some-examples-on-resreq",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Verify create user",
  "description": "",
  "id": "testing-some-examples-on-resreq;verify-create-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Createuser"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I am able to get the following end point",
  "rows": [
    {
      "cells": [
        "url",
        "endpoint"
      ],
      "line": 7
    },
    {
      "cells": [
        "QA.userServices",
        "users.create"
      ],
      "line": 8
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I send request for create user with below details",
  "rows": [
    {
      "cells": [
        "name",
        "job"
      ],
      "line": 11
    },
    {
      "cells": [
        "Raju",
        "SDET"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I should see user created successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I am able to get the following API endpoint",
  "rows": [
    {
      "cells": [
        "url",
        "endpoint"
      ],
      "line": 16
    },
    {
      "cells": [
        "QA.userServices",
        "users.get"
      ],
      "line": 17
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "I send get request for created user",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I should see newly created user details in response",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "I should see user fetched successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "Maveric.i_am_able_to_get_the_following_end_point(DataTable)"
});
formatter.result({
  "duration": 711085600,
  "status": "passed"
});
formatter.match({
  "location": "Maveric.i_send_request_for_create_user_with_below_details(DataTable)"
});
formatter.result({
  "duration": 2211626800,
  "status": "passed"
});
formatter.match({
  "location": "Maveric.i_should_see_user_created_successfully()"
});
formatter.result({
  "duration": 1658300,
  "status": "passed"
});
formatter.match({
  "location": "Maveric.i_am_able_to_get_the_following_API_endpoint(DataTable)"
});
formatter.result({
  "duration": 22891000,
  "status": "passed"
});
formatter.match({
  "location": "Maveric.i_send_get_request_for_created_user()"
});
formatter.result({
  "duration": 703951600,
  "status": "passed"
});
formatter.match({
  "location": "Maveric.i_should_see_newly_created_user_details_in_response()"
});
formatter.result({
  "duration": 349334000,
  "status": "passed"
});
formatter.match({
  "location": "Maveric.i_should_see_user_fetched_successfully()"
});
formatter.result({
  "duration": 628500,
  "error_message": "java.lang.AssertionError: User Created sucessfully expected [200] but found [201]\r\n\tat org.testng.Assert.fail(Assert.java:96)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:137)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:652)\r\n\tat stepDefinitions.Maveric.i_should_see_user_fetched_successfully(Maveric.java:99)\r\n\tat ✽.Then I should see user fetched successfully(C:/E_Personal/LearnigJ2EE/RestAPI_U_BDD/src/test/java/features/Maveric.feature:21)\r\n",
  "status": "failed"
});
});