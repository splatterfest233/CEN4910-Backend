#!/usr/bin/env python
# coding: utf-8

# - If the last <li> in the "paging" <nav> != "Next" we've reached the end of the search 
# - Delete Marketing Blurbs   
#     
#     
# STEPS TO GET PROPERTY DATA:
# - OPEN PROPERTY
#     - 
# SKIP PROP 26

# In[106]:


from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.common.exceptions import TimeoutException

PATH = "C:\Program Files (x86)\chromedriver.exe"
driver = webdriver.Chrome(PATH)
driver.get("https://www.apartments.com/orlando-fl/")


# In[104]:


import time

#Clear out total properties list.
totalProps = []
delay = 10 # delay in seconds
isLastPage = False
currPage = 1

while not isLastPage:
    #Wait until properties are loaded
    try:
        time.sleep(2)
        myElem = WebDriverWait(driver, delay).until(EC.presence_of_element_located((By.XPATH, '//*[@id="placardContainer"]/ul[1]/li/article')))
        print (currPage, "Page is ready to be scraped")
    except TimeoutException:
        print ("Loading took too much time")
    
    #Get properties on the current page
    pageProps = driver.find_elements(By.XPATH, '//*[@id="placardContainer"]/ul[1]/li/article')
    
    for i in range(1, len(pageProps)+1):
        currentElement = f'//*[@id="placardContainer"]/ul[1]/li[{i}]/article'
        currentProperty = driver.find_element(By.XPATH, currentElement)
        currentURL = currentProperty.get_attribute('data-url')
        if currentURL is not None:
            totalProps.append(currentURL)
    
    print(len(totalProps))

    #Get pagination list
    try:
        pagination = driver.find_elements(By.XPATH, '//*[@id="paging"]/ol/li')
        lastPage = pagination[-1]
        
        if lastPage.text == 'Next':
                myElem = WebDriverWait(driver, delay).until(EC.presence_of_element_located((By.XPATH, '//*[@id="paging"]/ol/li')))
                driver.find_elements(By.XPATH, '//*[@id="paging"]/ol/li')[-1].click()
                currPage += 1
        else:
            isLastPage = True
    except Exception as e:
        print(e, "Error:")


# In[120]:


from selenium.webdriver.common.action_chains import ActionChains

#Getting the data off each property
for currProp in totalProps:
    #Navigating to the Property's URL
    driver.get(currProp)
    time.sleep(2)
    
    #Declaring a new dictionary to store the property's information:
    propInfo = {}
    
    #FIELDS SCRAPED:
        #Property URL
    propURL = currProp
    
        #Property Title
    propName = driver.find_element(By.XPATH, '//*[@id="propertyName"]').text
    
        #Property Address, City, State, and Postal Code
    propAddress = driver.find_element(By.XPATH, '//*[@id="propertyAddressRow"]/div/h2/span[1]').text
    propCity = driver.find_element(By.XPATH, '//*[@id="propertyAddressRow"]/div/h2/span[2]').text
    propState = driver.find_element(By.XPATH, '//*[@id="propertyAddressRow"]/div/h2/span[3]/span[1]').text
    propZIP = driver.find_element(By.XPATH, '//*[@id="propertyAddressRow"]/div/h2/span[3]/span[2]').text
    propFullAddress = propAddress + ', ' + propCity + ', ' + propState + ' ' + propZIP
        
        #Property Rating
    rating = 0    
    ratingList = driver.find_elements(By.XPATH, '//*[@id="propertyReviewRow"]/div/div[1]/span[1]/i')
    for j in range(1, len(ratingList)+1):
        starURL = f'//*[@id="propertyReviewRow"]/div/div[1]/span[1]/i[{j}]'
        star = driver.find_element(By.XPATH, starURL)
        if star.get_attribute('class') == 'storyicon starFullStoryIcon':
            rating += 1
        elif star.get_attribute('class') == 'storyicon star50StoryIcon':
            rating += .5
                
        #Property Coordinates
    #Moving the browser to the Location section so the map gets generated.
    location = driver.find_element(By.XPATH, '//*[@id="mapSection"]/h2')
    actions = ActionChains(driver)
    actions.move_to_element(location).perform()
    
        #Property RentInfo
    propRent = driver.find_element(By.XPATH, '//*[@id="priceBedBathAreaInfoWrapper"]/div/div/ul/li[1]/div/p[2]').text
    print(propRent)
    
    #Sleep function is called to allow the website to fill out the information
    time.sleep(10)
    coorURL = driver.find_element(By.XPATH, '/html/body/div[1]/main/section[1]/div[1]/div[2]/div[1]/div[2]/section[6]/div[2]/div[1]/div/div[2]/div/div/div[14]/div/a').get_attribute('href')


# LOOP THROUGH THE TOTALPROPS ARRAY 
#     ENTER THE URL
#         GET THE INFORMATION
#         PUT IT INTO THE DICTIONARY
#         EXPORT THAT DICTIONARY AS A JSON
# 
