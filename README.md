📱 Robokalam Interview Task App
This Android application was developed as part of an interview task for Robokalam. The app demonstrates basic Android development skills including splash screen, login/onboarding flow, local storage with SharedPreferences and SQLite, API integration using Retrofit, and modern UI with material components.

✅ Features
1. 🚀 Splash Screen
Displays the Robokalam logo and app name.

Automatically navigates to login or dashboard based on login status.

2. 🔐 User Onboarding/Login Screen
Basic email login system.

No Firebase – only local email authentication.

Login state is saved using SharedPreferences.

Users can log out and return to login screen.

3. 🏠 Dashboard (Home Screen)
Displays a welcome message using the student’s name.

Contains navigation cards to:

Portfolio

Quote of the Day

About Robokalam

Logout

4. 📁 Portfolio Section
Allows users to enter and save personal information:

Name

College

Skills (at least 3)

Project Title & Description

Data is stored locally using Room (SQLite).

User can view and update portfolio data.

5. 💡 Quote of the Day
Fetches a motivational quote from https://zenquotes.io/api/random.

Uses Retrofit for API integration.

Displays quote and author inside a modern card view.

Gradient background and responsive UI.

6. ℹ️ About Robokalam Page
Static page with an image and descriptive paragraph about Robokalam.

Styled for readability and alignment with Robokalam branding.

🛠 Tech Stack
Component	Technology
Language	Kotlin
IDE	Android Studio
UI Components	Material UI, CardView
API Client	Retrofit + GSON
Local Storage	SharedPreferences
Database	Room (SQLite)


📦 Installation
Clone this repository:

git clone https://github.com/yourusername/robokalam-task-app.git
Open in Android Studio.

Connect Android Emulator or Device.


🔐 Credentials
Login with any email (no password required, just a valid email format).

🧠 Future Enhancements
Add profile picture upload in portfolio.

Dark mode support.

Realtime API for quotes instead of random once.

🧾 About Robokalam
ROBOKALAM is a 21st Century Edutech company focused on gamified education in AI, IoT, Robotics, etc. Through workshops, certification programs, and DIY kits, we empower students with hands-on tech education. Since 2015, we’ve organized the SKOOL ENGINE fest to promote student innovation.



