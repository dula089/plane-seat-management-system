# Plane Seat Management System

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Complete-success?style=for-the-badge)
![License](https://img.shields.io/badge/License-Academic-blue?style=for-the-badge)

**A comprehensive Java console application for managing airline seat reservations**

*Developed as part of Software Development II coursework (4COSC005W)*


</div>

---

##  Overview

This application simulates a **plane seat management system** with a 4-row aircraft configuration. It provides a complete solution for managing seat reservations, passenger information, and ticket generation with persistent file storage.

###  Academic Context
- **Course**: Software Development II (4COSC005W)
- **University**: University of Westminster
- **Academic Year**: 2023-2024
- **Student ID**: 20231280_w2052016

---

##  Aircraft Configuration

<div align="center">

| **Row** | **Seats** | **Configuration** |
|---------|-----------|-------------------|
| **A**   | 14 seats  | `1 2 3 4 5 6 7 8 9 10 11 12 13 14` |
| **B**   | 12 seats  | `1 2 3 4 5 6 7 8 9 10 11 12` |
| **C**   | 12 seats  | `1 2 3 4 5 6 7 8 9 10 11 12` |
| **D**   | 14 seats  | `1 2 3 4 5 6 7 8 9 10 11 12 13 14` |

**Total Capacity**: 52 seats

</div>

###  Visual Seating Plan
```
Row A: O O O O O O O O O O O O O O  (14 seats)
Row B:  O O O O O O O O O O O O     (12 seats)
Row C:  O O O O O O O O O O O O     (12 seats)  
Row D: O O O O O O O O O O O O O O  (14 seats)
```
> `O` = Available | `X` = Booked

---



## Features

### Core Functionality
- [x] **Seat Booking** - Reserve seats with complete passenger information
- [x] **Seat Cancellation** - Cancel existing reservations with validation
- [x] **Availability Search** - Find first available seat across all rows
- [x] **Seating Plan Display** - Real-time visual representation of seat status
- [x] **Ticket Management** - Search and display comprehensive ticket information
- [x] **Sales Reporting** - Calculate total revenue and generate sales reports

### Technical Features
- [x] **Object-Oriented Design** - Separate classes for Person, Ticket, and Main logic
- [x] **Input Validation** - Comprehensive validation with error handling
- [x] **File Persistence** - Automatic ticket file generation and storage
- [x] **Exception Handling** - Robust error management throughout the application
- [x] **Memory Management** - Efficient array-based data structures
- [x] **User Interface** - Intuitive console-based menu system

###  Security & Validation
- [x] **Email Validation** - Format checking with `@` and `.` requirements
- [x] **Seat Range Validation** - Row and seat number boundary checking
- [x] **Input Type Validation** - Try-catch blocks for numeric inputs
- [x] **Duplicate Booking Prevention** - Prevents double-booking of seats
- [x] **Empty Field Validation** - Ensures all required fields are completed

---

## Screenshots

### Main Menu Interface
```
*****************************************************
*                   MENU OPTIONS                    *
*****************************************************
         1) Buy a seat
         2) Cancel a seat
         3) Find first available seat
         4) Show seating plan
         5) Print tickets information and total sales
         6) Search ticket
         0) Exit
*****************************************************
Please select an option: 
```

### Seating Plan Display
```
O O O X O O O O O O O O O O
 O X O O O O O O O O O O
 O O O O O O O O O O O O
O O O O O O O O O O O O O O
```

### Ticket Information Display
```
Ticket Information
Row: A
Seat: 1
Price: 200.0
Ticket Holder Information
Name: John
Surname: Doe
Email: john.doe@email.com
```

---

##  Installation

### Prerequisites
- ![Java](https://img.shields.io/badge/Java-8+-orange) **Java JDK 8 or higher**
- ![IDE](https://img.shields.io/badge/IDE-IntelliJ%2FEclipse-blue) **IDE** (IntelliJ IDEA, Eclipse, or VS Code)
- ![OS](https://img.shields.io/badge/OS-Windows%2FmacOS%2FLinux-green) **Operating System** (Windows, macOS, or Linux)

### Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/dula089/plane-seat-management-system.git
   cd plane-seat-management-system
   ```

2. **Navigate to source directory**
   ```bash
   cd src
   ```

3. **Compile the Java files**
   ```bash
   javac *.java
   ```

4. **Run the application**
   ```bash
   java _20231280_w2052016_Planemanagement
   ```

### Project Structure
```
plane-seat-management-system/
├── 📂 src/
│   ├── 📄 _20231280_w2052016_Planemanagement.java  # Main application
│   ├── 📄 Person.java                              # Person entity
│   └── 📄 Ticket.java                             # Ticket entity
├── 📂 docs/
│   └── 📄 coursework.pdf              # coursework
├── 📄 A2.txt                                    # Generated ticket files
├── 📄 README.md                                    # This file
├── 📄 .gitignore                                   # Git ignore rules
└── 📄 LICENSE                                      # License information
```

---

## Usage Guide

### Main Menu Navigation

| **Option** | **Function** | **Description** |
|------------|--------------|-----------------|
| `1` | **Buy a seat** | Book a new reservation with passenger details |
| `2` | **Cancel a seat** | Cancel an existing seat reservation |
| `3` | **Find first available** | Locate the next available seat |
| `4` | **Show seating plan** | Display current seat status visually |
| `5` | **Print tickets info** | Show all booked tickets and total sales |
| `6` | **Search ticket** | Find and display specific ticket information |
| `0` | **Exit** | Close the application safely |

### Step-by-Step Booking Process

1. **Select Option 1** from the main menu
2. **Enter Row Letter** (A, B, C, or D)
   ```
   Enter row(A/B/C/D): A
   ```
3. **Enter Seat Number** (varies by row: A&D=1-14, B&C=1-12)
   ```
   Enter seat number: 5
   ```
4. **Provide Passenger Information**:
   ```
   Enter your name: John
   Enter your surname: Doe
   Enter your email: john.doe@email.com
   ```
5. **Confirmation & File Generation**
   ```
   Seat successfully booked.
   Ticket information saved to file: A5.txt
   ```

###  Advanced Features

#### Searching for Tickets
```bash
# Search by seat location
Enter row(A/B/C/D): B
Enter seat number: 7
# Returns complete ticket and passenger information
```

#### Sales Reporting
```bash
# Displays all tickets and calculates total revenue
Tickets Information
Row: A, Seat: 1, Price: £200.00
Row: B, Seat: 7, Price: £150.00
Total Sales: £350.00
```
