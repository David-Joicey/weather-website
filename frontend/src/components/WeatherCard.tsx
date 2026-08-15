import "./WeatherCard.css";
import weatherCodeConverter from "./weatherCodeConverter";

interface WeatherCardAttributes {
    date: string;
    data: {
        maxTemp: number;
        minTemp: number;
        humidity: number;
        precipitation: number;
        weatherCode: number;
    }
}

function WeatherCard(weatherCardAttributes: WeatherCardAttributes) {
    return (
        <div className="weather-card-container">
            <h3 className="weather-card-date">{weatherCardAttributes.date}</h3>

            <div className="weather-card-info">
                <p>Max Temp: {weatherCardAttributes.data.maxTemp}*C</p>
                <p>Min Temp: {weatherCardAttributes.data.minTemp}*C</p>
                <p>Humidity: {weatherCardAttributes.data.humidity}%</p>
                <p>Precipitation: {weatherCardAttributes.data.precipitation}mm</p>
                <p>Weather: {weatherCodeConverter(weatherCardAttributes.data.weatherCode)}</p>
            </div>
        </div>
    )
}
export default WeatherCard;