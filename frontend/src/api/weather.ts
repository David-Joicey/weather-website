import axios from "axios";

export const getWeather = async (location: string) => {
  const response = await axios.get(
    `http://localhost:8080/weather/${location}`
  );
  return response.data;
};