package com.example.proto.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MediaType;

import java.io.IOException;

public class SendController {
   /* String url = "https://netzebw600.webhook.office.com/webhookb2/7c9e1637-4cd0-4ca0-b7db-29cf94c867b3@6acddf22-08fd-4573-b5a7-51abbd1c4b68/IncomingWebhook/8e27be66ca9e4a8db8cf24d2a3c5007b/dbd99df0-6bde-424e-8330-5567b1e84e05";

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         if (request.getParameter("sendButton") != null) {

             System.out.println("test");
             post();
         }
         System.out.println("test");
         //request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
     }

    public void post() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"@type\": \"MessageCard\",\r\n  \"@context\": \"http://schema.org/extensions\",\r\n  \"themeColor\": \"0076D7\",\r\n  \"summary\": \"Larry Bryant created a new task\",\r\n  \"sections\": [{\r\n    \"activityTitle\": \"Larry Bryant created a new task\",\r\n    \"activitySubtitle\": \"On Project Tango\",\r\n    \"activityImage\": \"https://teamsnodesample.azurewebsites.net/static/img/image5.png\",\r\n    \"facts\": [{\r\n      \"name\": \"Assigned to\",\r\n      \"value\": \"Unassigned\"\r\n    }, {\r\n      \"name\": \"Due date\",\r\n      \"value\": \"Mon May 01 2017 17:07:18 GMT-0700 (Pacific Daylight Time)\"\r\n    }, {\r\n      \"name\": \"Status\",\r\n      \"value\": \"Not started\"\r\n    }],\r\n    \"markdown\": true\r\n  }],\r\n  \"potentialAction\": [{\r\n    \"@type\": \"ActionCard\",\r\n    \"name\": \"Add a comment\",\r\n    \"inputs\": [{\r\n      \"@type\": \"TextInput\",\r\n      \"id\": \"comment\",\r\n      \"isMultiline\": false,\r\n      \"title\": \"Add a comment here for this task\"\r\n    }],\r\n    \"actions\": [{\r\n      \"@type\": \"HttpPOST\",\r\n      \"name\": \"Add comment\",\r\n      \"target\": \"https://docs.microsoft.com/outlook/actionable-messages\"\r\n    }]\r\n  }, {\r\n    \"@type\": \"ActionCard\",\r\n    \"name\": \"Set due date\",\r\n    \"inputs\": [{\r\n      \"@type\": \"DateInput\",\r\n      \"id\": \"dueDate\",\r\n      \"title\": \"Enter a due date for this task\"\r\n    }],\r\n    \"actions\": [{\r\n      \"@type\": \"HttpPOST\",\r\n      \"name\": \"Save\",\r\n      \"target\": \"https://docs.microsoft.com/outlook/actionable-messages\"\r\n    }]\r\n  }, {\r\n    \"@type\": \"OpenUri\",\r\n    \"name\": \"Learn More\",\r\n    \"targets\": [{\r\n      \"os\": \"default\",\r\n      \"uri\": \"https://docs.microsoft.com/outlook/actionable-messages\"\r\n    }]\r\n  }, {\r\n    \"@type\": \"ActionCard\",\r\n    \"name\": \"Change status\",\r\n    \"inputs\": [{\r\n      \"@type\": \"MultichoiceInput\",\r\n      \"id\": \"list\",\r\n      \"title\": \"Select a status\",\r\n      \"isMultiSelect\": \"false\",\r\n      \"choices\": [{\r\n        \"display\": \"In Progress\",\r\n        \"value\": \"1\"\r\n      }, {\r\n        \"display\": \"Active\",\r\n        \"value\": \"2\"\r\n      }, {\r\n        \"display\": \"Closed\",\r\n        \"value\": \"3\"\r\n      }]\r\n    }],\r\n    \"actions\": [{\r\n      \"@type\": \"HttpPOST\",\r\n      \"name\": \"Save\",\r\n      \"target\": \"https://docs.microsoft.com/outlook/actionable-messages\"\r\n    }]\r\n  }]\r\n}");
        Request request = new Request.Builder()
                .url("https://netzebw600.webhook.office.com/webhookb2/7c9e1637-4cd0-4ca0-b7db-29cf94c867b3@6acddf22-08fd-4573-b5a7-51abbd1c4b68/IncomingWebhook/8e27be66ca9e4a8db8cf24d2a3c5007b/dbd99df0-6bde-424e-8330-5567b1e84e05")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
    }*/
}
//WebClient oder RestTemplate
//TeamsAPIService sendwebhook()

//PostMapping(path = "/post")
//public string post(model, text)
//addatribute(text)

//service.sendwebhook()