# 🔢 Calculator App

A simple **Android Calculator** built with **Kotlin** and the traditional **View system** (XML + `AppCompatActivity`).  
This app performs **basic arithmetic operations** and handles edge cases like negative numbers, multiple zeros, and decimal points.

---

## ✨ Features

- 🖩 **Basic Operations**  
  Addition (+), Subtraction (−), Multiplication (×), and Division (÷).  

- ⌨️ **Custom Input Handling**  
  - Prevents multiple leading zeros (e.g., avoids `0001`).  
  - Prevents multiple decimals in a number.  
  - Allows entering negative numbers (e.g., `-5 + 3`).  

- 🧹 **Clear Function**  
  - "C" button resets the input.  
  - Display shows `0` when cleared.  

- 🟰 **Equals Button**  
  - Displays the result in the hint if the input is empty after calculation.  
  - Supports continuous calculations without resetting everything.  

---

## 🛠️ Tech Stack

- **Language**: Kotlin  
- **UI**: XML Layouts + `AppCompatActivity`  
- **Android Components**: `EditText`, `Button`  
- **Input Control**: `InputType.TYPE_NULL` (to disable soft keyboard)  

---

## 📂 Code Overview

- **MainActivity.kt**  
  - Contains all the logic for:
    - Handling button clicks (`0–9`, `.`, operators, `=`).  
    - Preventing invalid inputs using flags (`flag0`, `flag1`, `flag2`, etc.).  
    - Storing first operand, second operand, operator, and result.  
  - Updates `EditText` and `hint` dynamically.  

---

## 🚀 Usage

1. Launch the app.  
2. Tap number buttons (`0–9`) to enter digits.  
3. Use operators (`+`, `−`, `×`, `÷`) to set the operation.  
4. Tap `=` to calculate.  
5. Tap `C` to clear and reset the display.  


