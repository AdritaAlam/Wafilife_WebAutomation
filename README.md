# Wafilife Web Automation Project

## Overview

This project automates the testing of [Wafilife](https://www.wafilife.com/) website using **Selenium WebDriver** and **TestNG**.
It covers login functionality, author navigation, and book ordering processes. The framework supports **data-driven testing**, **parallel execution**, and **Allure reporting**.

---

## Features

* **Login Testing**

  * Valid login scenario
  * Invalid login scenario (data-driven using Excel/CSV)
* **Author Navigation**

  * Click লেখক menu
  * Scroll and navigate to the next page
* **Book Ordering**

  * Select author → select book → view details → add to cart → complete order
* **Parallel Execution**

  * Configured via `testng.xml`
* **Allure Reporting**

  * Generate attractive test reports using command line

---

## Tech Stack

* **Language:** Java
* **Framework:** Selenium WebDriver + TestNG
* **Build Tool:** Maven
* **Reporting:** Allure Reports
* **Data Source:** Dataset class for invalid credentials

---

## Project Structure

```
Wafilife_Automation/
│
├── pages/                 # Page Object Model classes (BasePage, LoginPage, HomePage, BillingInfo etc.)
├── testcases/             # Test scripts (TestLogin, TestActions, TestHomepage)
├── utilities/             # Utilities (DriverSetup, DataProviders)
├── testng.xml             # Parallel execution configuration
├── pom.xml                # Maven dependencies
└── README.md              # Documentation
```

---

## Prerequisites

* **Java JDK 8 or above** installed
* **Maven** installed and added to PATH
* **Allure commandline** installed (for report generation)

---

## Installation & Setup

### 1. Clone Repository

```bash
git clone https://github.com/AdritaAlam/Wafilife_WebAutomation.git
```

### 2. Install Dependencies

```bash
mvn clean install
```

---

## Running Tests

### Run All Tests

```bash
mvn test
```

### Run Using `testng.xml` (Parallel Execution)

```bash
mvn clean test -DsuiteXmlFile="testng.xml"
```

---

## Generate Allure Report

After running tests, generate and open the report with:

```bash
allure generate .\allure-results\ --clean
allure open .\allure-report

```

---

## Automated Test Scenario

### Scenario: Book Order Flow

**Steps:**

1. Visit [Wafilife](https://www.wafilife.com/)
2. Login with valid credentials
3. Click **লেখক** from the menu
4. Scroll down and navigate to next page
5. Select any author
6. View any book details
7. Click **অর্ডার করুন**
8. Click **অর্ডার সম্পন্ন করুন**
9. Provide all information in **আপনার বিলিং এবং শিপিং তথ্য**
10. Log out

**Expected Result:**

* User logs in successfully, navigates to author page, selects a book, places an order, and logs out without errors.

---

## Test Execution Summary
- **Total Test Cases:** 8  
- **Passed:** 8  
- **Failed:** 0
  
After test execution, generate Allure report:
<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/b7a2b869-c87b-4ee4-8978-30cd003cafe5" />
<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/ef737550-29d1-4d86-ab6b-c6c9109c4e05" />
<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/3376aeb4-3c3a-43d6-8766-40fd35a2b68d" />




---

