import axios from "axios";

export const getWeather = async (city: string) => {
  const response = await axios.get(
    `http://localhost:8080/api/weather/${city}`
  );
  return response.data;
};