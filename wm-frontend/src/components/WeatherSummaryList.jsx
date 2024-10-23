// src/components/WeatherSummaryList.jsx

import { useEffect, useState } from 'react';
import { fetchWeatherSummaries } from '../api/weatherApi';
import WeatherSummary from './WeatherSummary';
import WeatherChart from './WeatherChart';  // Import the WeatherChart component

const WeatherSummaryList = ({ city }) => {
    const [summaries, setSummaries] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const getWeatherSummaries = async () => {
            setLoading(true);
            setError(null);
            try {
                const data = await fetchWeatherSummaries(city);
                setSummaries(data);
            } catch (err) {
                setError('Failed to fetch weather summaries');
            } finally {
                setLoading(false);
            }
        };

        getWeatherSummaries();
    }, [city]);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>{error}</p>;

    return (
        <div className="weather-summary-list">
            {summaries.map((summary) => (
                <WeatherSummary key={summary.date} summary={summary} />
            ))}
            <WeatherChart summaries={summaries} />  {/* Add the WeatherChart here */}
        </div>
    );
};

export default WeatherSummaryList;
