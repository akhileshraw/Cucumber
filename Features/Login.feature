Feature: Login

Scenario: Successful Login with Valid Credentials
  Given User Launch Chrome Browser
  When User opens URL "http://admin-demo.nopcommerce.com/login"
  And User Enters Email as "admin@yourstore.com" and Password as "admin"
  And Click on Login
  Then Page Title should be "Dashboard / nonCommerce administration"
  When User click on Log out link
  Then Page Title should be "Your store. Login"
  And close browser  