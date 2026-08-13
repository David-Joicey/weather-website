import "./Search.css";
import { getWeather } from "../api/weather";
import { useState } from "react";

function search() {
    const [location, setLocation] = useState("");

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<string | null>(null);
    const [weather, setWeather] = useState<any>(null);

    async function handleSubmit(e: React.FormEvent) {
        e.preventDefault();

        if (!location.trim()) return;

        setLoading(true);
        setError(null);

        try {
            const data = await getWeather(location);
            console.log("Weather data:", data);
            setWeather(data);
        } catch (err) {
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
            {weather && <pre>{JSON.stringify(weather, null, 2)}</pre>}
        </div>
    )
}
export default search;