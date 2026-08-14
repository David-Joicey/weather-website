import "./Search.css";
import { getWeather } from "../api/weather";
import { useState } from "react";
import WeatherCard from "../components/WeatherCard";

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

function search() {
    const [location, setLocation] = useState("");

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<string | null>(null);
    const [weather, setWeather] = useState<WeatherCardAttributes[]>([]);


    async function handleSubmit(e: React.SubmitEvent) {
        e.preventDefault();

        if (!location.trim()) return;

        setLoading(true);
        setError(null);

        try {
            const data = await getWeather(location);

            console.log("RAW backend response:", data);

            const cards = data.weatherData.map((day: any) => ({
                date: day.date,
                data: {
                    maxTemp: day.maxTemp,
                    minTemp: day.minTemp,
                    humidity: day.humidity,
                    precipitation: day.precipitation,
                    weatherCode: day.weatherCode
                }
            }));

            console.log("Weather data:", data);
            setWeather(cards);
        } catch (err) {
            console.error("Fetch error:", err);
            setError("Could not fetch weather data");
        } finally {
            setLoading(false);
        }
  }

    return(
        <div className = "page-container">
            <h1 className = "title">Weather Search</h1>

            <form className = "search-container" onSubmit={handleSubmit}>
                <input
                className = "search-bar"
                type = "text"
                placeholder = "Location..."
                value = {location}
                onChange={(e) => setLocation(e.target.value)}
                />

                <button type="submit" className="search-button">Search</button>
            </form>

            {loading && <p>Loading...</p>}
            {error && <p>{error}</p>}
            {weather && (
                <div className="weather-grid">
                    {weather.map((card: WeatherCardAttributes, index: number) => (
                        <WeatherCard
                            key={index}
                            date={card.date}
                            data={card.data}
                        />
                    ))}
                </div>
            )}
        </div>
    )
}
export default search;