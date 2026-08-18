# weather-website

## Overview

This project is a web-based weather dashboard with a Spring Boot Backend and a React Frontend which provides the following features:

- React-based GUI allowing for weather data searching and viewing based on location name with cases of no location being found handled gracefully and clearly relayed to the user.

- Spring boot backend endpoint which takes the user given location and converts it into geographical coordinates using Open-Meto's Geocoding API.

- Fetching of weather data for the date searched + the next 6 days using Open-Meteo's Weather Forecast API.

## Setup

### Backend Terminal Commands

Directory:  `/weather-website/backend`

Initialise: `./gradlew build`

Run: `./gradlew bootRun`

### Frontend Terminal Commands

Directory: `/weather-website/frontend`

Initialise: `npm install`

Run: `npm run dev`

### Ports

Backend: http://localhost:8080

Frontend http://localhost:5173/