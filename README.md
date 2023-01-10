# SeleniumJavaAutomation

This simple project is created as an excercise and currently is Work In Progress.

It roughly follows a very popular online Selenium training, however I decided to do all the tasks in a different (maybe better) way than presented on the videos.

## Characteristics
- Page-Object Model
- PageFactory
- Allure steps
- each @Test is run in a sepparate browser instance


## Test Cases

There are two pages under test and you can find there following test cases:

**1. Drop-downs practise page (simulation of airline booking portal)**
  - static dropdown
    - Verify if there is a possibility to change currency
  - dynamic dropdown
    - Verify if there is a possibility to pick number of Adult passengers
    - Verify if there is a possibility to pick a departure/arrival city
  - autosuggestive dropdown
    - Verify if auto-suggestive dropdown presents correct options to the User
  - checkboxes
    - Verify if there is possibility to pick discount options
    - Verify if there is possibility to pick discount options - parametrized tests (run one by one)
  - calendar
    - Verify if there is possibility to set departure date to current day
  - radio buttons
    - Verify if changing type of trip disables and enables calendar options
  - E2E scenario
    - Verify if you can search for One Way Trip from Jaipur to Goa for 3 Adults (USD)
    
    
**2. Automation Practise Page**
  - browser alerts
    - Verify if provided name appears on the Alert pop-up
    - Verify if there is possibility to not confirm on pop-up
