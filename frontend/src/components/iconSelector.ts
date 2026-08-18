const weatherIcons: Record<number, string> = {
  0: "clear.png",
  1: "part-cloud.png",
  2: "part-cloud.png",
  3: "overcast.png",

  45: "fog.png",
  48: "fog.png",

  51: "drizzle.png",
  53: "drizzle.png",
  55: "drizzle.png",
  56: "drizzle.png",
  57: "drizzle.png",

  61: "rain.png",
  63: "rain.png",
  65: "rain.png",
  66: "rain.png",
  67: "rain.png",

  71: "snow.png",
  73: "snow.png",
  75: "snow.png",
  77: "snow.png",

  80: "rain.png",
  81: "rain.png",
  82: "rain.png",

  85: "snow.png",
  86: "snow.png",

  95: "thunder.png",
  96: "thunder.png",
  99: "thunder.png",
};

function getIcon(code: number): string {
    return weatherIcons[code];
} export default getIcon;