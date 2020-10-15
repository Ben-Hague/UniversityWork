# DLNUM = DLNUM STRING
# NearDate = Date to book test near 'dd/mm/yyyy'
# CutoffMonth = last month to book int
# CutoffYear = last year to book, int 
# ie if want a test november 2020 cut off is 10/2020
#there is no year overlap coded as this wasnt needed by me, the logic would go around Line 78
# ADI = True (bool) ADI NUmber here 
# ADINUM = String ADI NUM
# POSTCODE = POSTcode string to find test number
# CENTERID = test center number, string (Find online)
# RepeatPeriod = 2 Repeat search every 2 min (doesnt trigger timeout)


from personal import *

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time 
driver = webdriver.Chrome('./chromedriver')
def CheckSite(driver):
    driver.get('https://driverpracticaltest.dvsa.gov.uk/application')
    #print(driver.title) #Page1 Test Type

    CarOption = driver.find_element_by_name("testTypeCar")
    CarOption.click()

    #print(driver.title) #Page2 DL NUM and Extra Requests

    Licence = driver.find_element_by_id("driving-licence")
    Court = driver.find_element_by_id("extended-test-no")
    SpecReq = driver.find_element_by_id("special-needs-none")
    Submit = driver.find_element_by_id("driving-licence-submit")

    Licence.send_keys(DLNUM)
    Court.click()
    SpecReq.click()
    Submit.click()


    #print(driver.title) #Page3


    Date = driver.find_element_by_id('test-choice-calendar')
    Instructor = driver.find_element_by_id('instructor-prn')
    Date.send_keys(NearDate)
    
    Submit = driver.find_element_by_id("driving-licence-submit")
    if ADI:
        Instructor.send_keys(ADINUM)
    Submit.click()


    #print(driver.title) #Page4
    
    
    LOC = driver.find_element_by_id('test-centres-input')
    Submit = driver.find_element_by_id("test-centres-submit")

    LOC.send_keys(POSTCODE)
    Submit.click()
    
    
    #print(driver.title) #Page5 Find the date!!!
    
    
    Center = driver.find_element_by_id('centre-name-'+CENTERID)
    Latest = Center.text +' '
    Date = Latest[-11:-1]
    print(Date)
    time.sleep(0.5)
    Center.click()
    
    Next = driver.find_element_by_class_name('BookingCalendar-date--bookable ')   
    Next.click()
    if Date[6:10] == "ound":
        return False
        
    if int(Date[6:10])<=CutoffYear:
        print('IN 2020')
        if int(Date[3:5])<=CutoffMonth:
            Slot = driver.find_element_by_class_name('SlotPicker-time')
            print(Slot.text)
            Slot.click()
            Submit = driver.find_element_by_id('slot-chosen-submit')
            Submit.click()
            Submit = driver.find_element_by_id('slot-warning-continue')
            Submit.click()
            return True 

    return False


i=0
while True:
    i+=1
    print(i)
    if CheckSite(driver):
        time.sleep(60*15)
    else:
        time.sleep((RepeatPeriod*60)-5)
    
