import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC



@pytest.fixture
def chrome_driver():

    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.implicitly_wait(20)
    driver.get("https://nocode.autify.com/")

    yield driver

    driver.quit()



def test_mobilefeature(chrome_driver):
    
    chrome_driver.find_element(By.XPATH, "//a[contains(@class, 'tabs-nav-item _02')]").click()

    mobileViewTab = WebDriverWait(chrome_driver, 5).until(
        EC.visibility_of_element_located((By.XPATH, "//div[@id='w-tabs-0-data-w-pane-1']")))
    pageText = chrome_driver.find_element(By.XPATH, "//*[contains(@src, 'mobile-feature-visualregression')]/following::div[@class='nc-ft-card-title-heading']")

    assert True == mobileViewTab.is_displayed()
    assert "Visual Regression" == pageText.text


def test_webfeature(chrome_driver):
    
    chrome_driver.find_element(By.XPATH, "//a[contains(@class, 'tabs-nav-item _02')]").click()

    mobileViewTab = WebDriverWait(chrome_driver, 5).until(
        EC.visibility_of_element_located((By.XPATH, "//div[@id='w-tabs-0-data-w-pane-1']")))

    chrome_driver.find_element(By.XPATH, "//a[contains(@class, 'tabs-nav-item _01')]").click()

    webViewTab = WebDriverWait(chrome_driver, 5).until(
        EC.visibility_of_element_located((By.XPATH, "//div[@id='w-tabs-0-data-w-pane-0']")))

    pageText = chrome_driver.find_element(By.XPATH, "//*[contains(@src, 'web-feature-cross-browser')]/following::div[@class='nc-ft-card-title-heading']")

    assert True == webViewTab.is_displayed()
    assert "Cross-browser Testing" == pageText.text
