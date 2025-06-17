# 🧠 Brain Dump – Mind Mess Organizer

Brain Dump is a personal note-taking tool designed to **quickly capture your thoughts**, organize them, and use AI to categorize them intelligently.

> ⚠️ **Note**: This is currently a self-use project and a **work in progress**.

---

## ✨ Features

- 🎙️ **Speech-to-Text Input**: Speak your thoughts, and they get converted to notes.
- 📝 **Text Note Entry**: Write short or long notes through a simple UI.
- 🧠 **AI-based Categorization**: Automatically categorizes notes using [Google Gemini API](https://ai.google.dev/).
- 🗂️ **Predefined Categories**:
  - IDEA
  - TASK
  - REMINDER
  - RANT
  - QUESTION
  - SHOPPING_LIST
  - RANDOM

---

## 📦 Tech Stack

- **Backend**: Spring Boot (Java 17)
- **Frontend**: React
- **AI Integration**: Google Gemini API
- **Build Tool**: Gradle

---

## 🔧 Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/Shubham798/BrainDump.git
cd BrainDump
```

### 2. Add your Gemini API Key

In `src/main/resources/application.properties`:

```properties
gemini.api.key=your_api_key_here
```

> Or set it via environment variable `GEMINI_API_KEY`.

### 3. Run the application

```bash
./gradlew bootRun
```

---

## 🚧 Work in Progress

This is a personal utility project that is still being actively developed.

---