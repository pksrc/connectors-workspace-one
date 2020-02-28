package com.vmware.connectors.ms.graph.config

import java.util.*

const val DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"

const val PENDING_ACCESS_REQUESTS_SINCE_HOURS = 10L

val CALENDAR: Calendar = Calendar.getInstance()

val dayLightTimeZones = listOf(
        "Eastern Standard Time",
        "Atlantic Standard Time",
        "Central Standard Time",
        "Mountain Standard Time",
        "Pacific Standard Time",
        "Alaskan Standard Time",
        "Aleutian Standard Time"
)

val windowsTimeZones = mapOf(
        "Dateline Standard Time" to "(UTC-12:00) International Date Line West",
        "Samoa Standard Time" to "(UTC+13:00) Samoa",
        "UTC-11" to "(UTC-11:00) Coordinated Universal Time-11",
        "Aleutian Standard Time" to "(UTC-10:00) Aleutian Islands",
        "Hawaiian Standard Time" to "(UTC-10:00) Hawaii",
        "Marquesas Standard Time" to "(UTC-09:30) Marquesas Islands",
        "Alaskan Standard Time" to "(UTC-09:00) Alaska",
        "UTC-09" to "(UTC-09:00) Coordinated Universal Time-09",
        "Pacific Standard Time (Mexico)" to "(UTC-08:00) Baja California",
        "UTC-08" to "(UTC-08:00) Coordinated Universal Time-08",
        "Pacific Standard Time" to "(UTC-08:00) Pacific Time (US & Canada)",
        "US Mountain Standard Time" to "(UTC-07:00) Arizona",
        "Mountain Standard Time (Mexico)" to "(UTC-07:00) Chihuahua, La Paz, Mazatlan",
        "Mountain Standard Time" to "(UTC-07:00) Mountain Time (US & Canada)",
        "Eastern Standard Time (Mexico)" to "(UTC-05:00) Chetumal",
        "Central America Standard Time" to "(UTC-06:00) Central America",
        "Central Standard Time" to "(UTC-06:00) Central Time (US & Canada)",
        "Easter Island Standard Time" to "(UTC-06:00) Easter Island",
        "Central Standard Time (Mexico)" to "(UTC-06:00) Guadalajara, Mexico City, Monterrey",
        "Canada Central Standard Time" to "(UTC-06:00) Saskatchewan",
        "SA Pacific Standard Time" to "(UTC-05:00) Bogota, Lima, Quito, Rio Branco",
        "Eastern Standard Time" to "(UTC-05:00) Eastern Time (US & Canada)",
        "Haiti Standard Time" to "(UTC-05:00) Haiti",
        "Cuba Standard Time" to "(UTC-05:00) Havana",
        "US Eastern Standard Time" to "(UTC-05:00) Indiana (East)",
        "Turks And Caicos Standard Time" to "(UTC-05:00) Turks and Caicos",
        "Venezuela Standard Time" to "(UTC-04:00) Caracas",
        "Magallanes Standard Time" to "(UTC-03:00) Punta Arenas",
        "Paraguay Standard Time" to "(UTC-04:00) Asuncion",
        "Atlantic Standard Time" to "(UTC-04:00) Atlantic Time (Canada)",
        "Central Brazilian Standard Time" to "(UTC-04:00) Cuiaba",
        "SA Western Standard Time" to "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan",
        "Pacific SA Standard Time" to "(UTC-04:00) Santiago",
        "Newfoundland Standard Time" to "(UTC-03:30) Newfoundland",
        "Tocantins Standard Time" to "(UTC-03:00) Araguaina",
        "E. South America Standard Time" to "(UTC-03:00) Brasilia",
        "SA Eastern Standard Time" to "(UTC-03:00) Cayenne, Fortaleza",
        "Argentina Standard Time" to "(UTC-03:00) City of Buenos Aires",
        "Greenland Standard Time" to "(UTC-03:00) Greenland",
        "Montevideo Standard Time" to "(UTC-03:00) Montevideo",
        "Saint Pierre Standard Time" to "(UTC-03:00) Saint Pierre and Miquelon",
        "Bahia Standard Time" to "(UTC-03:00) Salvador",
        "UTC-02" to "(UTC-02:00) Coordinated Universal Time-02",
        "Mid-Atlantic Standard Time" to "(UTC-02:00) Mid-Atlantic - Old",
        "Azores Standard Time" to "(UTC-01:00) Azores",
        "Cape Verde Standard Time" to "(UTC-01:00) Cabo Verde Is.",
        "UTC" to "(UTC) Coordinated Universal Time",
        "GMT Standard Time" to "(UTC+00:00) Dublin, Edinburgh, Lisbon, London",
        "Greenwich Standard Time" to "(UTC+00:00) Monrovia, Reykjavik",
        "Morocco Standard Time" to "(UTC+01:00) Casablanca",
        "W. Europe Standard Time" to "(UTC+01:00) Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna",
        "Central Europe Standard Time" to "(UTC+01:00) Belgrade, Bratislava, Budapest, Ljubljana, Prague",
        "Romance Standard Time" to "(UTC+01:00) Brussels, Copenhagen, Madrid, Paris",
        "Central European Standard Time" to "(UTC+01:00) Sarajevo, Skopje, Warsaw, Zagreb",
        "W. Central Africa Standard Time" to "(UTC+01:00) West Central Africa",
        "Libya Standard Time" to "(UTC+02:00) Tripoli",
        "Namibia Standard Time" to "(UTC+02:00) Windhoek",
        "Jordan Standard Time" to "(UTC+02:00) Amman",
        "GTB Standard Time" to "(UTC+02:00) Athens, Bucharest",
        "Middle East Standard Time" to "(UTC+02:00) Beirut",
        "Egypt Standard Time" to "(UTC+02:00) Cairo",
        "E. Europe Standard Time" to "(UTC+02:00) Chisinau",
        "Syria Standard Time" to "(UTC+02:00) Damascus",
        "West Bank Standard Time" to "(UTC+02:00) Gaza, Hebron",
        "South Africa Standard Time" to "(UTC+02:00) Harare, Pretoria",
        "FLE Standard Time" to "(UTC+02:00) Helsinki, Kyiv, Riga, Sofia, Tallinn, Vilnius",
        "Israel Standard Time" to "(UTC+02:00) Jerusalem",
        "Kaliningrad Standard Time" to "(UTC+02:00) Kaliningrad",
        "Sudan Standard Time" to "(UTC+02:00) Khartoum",
        "Turkey Standard Time" to "(UTC+03:00) Istanbul",
        "Belarus Standard Time" to "(UTC+03:00) Minsk",
        "Arabic Standard Time" to "(UTC+03:00) Baghdad",
        "Arab Standard Time" to "(UTC+03:00) Kuwait, Riyadh",
        "Russian Standard Time" to "(UTC+03:00) Moscow, St. Petersburg",
        "E. Africa Standard Time" to "(UTC+03:00) Nairobi",
        "Astrakhan Standard Time" to "(UTC+04:00) Astrakhan, Ulyanovsk",
        "Russia Time Zone 3" to "(UTC+04:00) Izhevsk, Samara",
        "Saratov Standard Time" to "(UTC+04:00) Saratov",
        "Volgograd Standard Time" to "(UTC+04:00) Volgograd",
        "Iran Standard Time" to "(UTC+03:30) Tehran",
        "Arabian Standard Time" to "(UTC+04:00) Abu Dhabi, Muscat",
        "Azerbaijan Standard Time" to "(UTC+04:00) Baku",
        "Mauritius Standard Time" to "(UTC+04:00) Port Louis",
        "Georgian Standard Time" to "(UTC+04:00) Tbilisi",
        "Caucasus Standard Time" to "(UTC+04:00) Yerevan",
        "Afghanistan Standard Time" to "(UTC+04:30) Kabul",
        "West Asia Standard Time" to "(UTC+05:00) Ashgabat, Tashkent",
        "Ekaterinburg Standard Time" to "(UTC+05:00) Ekaterinburg",
        "Pakistan Standard Time" to "(UTC+05:00) Islamabad, Karachi",
        "Qyzylorda Standard Time" to "(UTC+05:00) Qyzylorda",
        "India Standard Time" to "(UTC+05:30) Chennai, Kolkata, Mumbai, New Delhi",
        "Sri Lanka Standard Time" to "(UTC+05:30) Sri Jayawardenepura",
        "Nepal Standard Time" to "(UTC+05:45) Kathmandu",
        "Central Asia Standard Time" to "(UTC+06:00) Astana",
        "Bangladesh Standard Time" to "(UTC+06:00) Dhaka",
        "Omsk Standard Time" to "(UTC+06:00) Omsk",
        "Altai Standard Time" to "(UTC+07:00) Barnaul, Gorno-Altaysk",
        "N. Central Asia Standard Time" to "(UTC+07:00) Novosibirsk",
        "Tomsk Standard Time" to "(UTC+07:00) Tomsk",
        "Myanmar Standard Time" to "(UTC+06:30) Yangon (Rangoon)",
        "SE Asia Standard Time" to "(UTC+07:00) Bangkok, Hanoi, Jakarta",
        "W. Mongolia Standard Time" to "(UTC+07:00) Hovd",
        "North Asia Standard Time" to "(UTC+07:00) Krasnoyarsk",
        "China Standard Time" to "(UTC+08:00) Beijing, Chongqing, Hong Kong, Urumqi",
        "North Asia East Standard Time" to "(UTC+08:00) Irkutsk",
        "Singapore Standard Time" to "(UTC+08:00) Kuala Lumpur, Singapore",
        "W. Australia Standard Time" to "(UTC+08:00) Perth",
        "Taipei Standard Time" to "(UTC+08:00) Taipei",
        "Ulaanbaatar Standard Time" to "(UTC+08:00) Ulaanbaatar",
        "Transbaikal Standard Time" to "(UTC+09:00) Chita",
        "North Korea Standard Time" to "(UTC+09:00) Pyongyang",
        "Aus Central W. Standard Time" to "(UTC+08:45) Eucla",
        "Tokyo Standard Time" to "(UTC+09:00) Osaka, Sapporo, Tokyo",
        "Korea Standard Time" to "(UTC+09:00) Seoul",
        "Yakutsk Standard Time" to "(UTC+09:00) Yakutsk",
        "Cen. Australia Standard Time" to "(UTC+09:30) Adelaide",
        "AUS Central Standard Time" to "(UTC+09:30) Darwin",
        "E. Australia Standard Time" to "(UTC+10:00) Brisbane",
        "AUS Eastern Standard Time" to "(UTC+10:00) Canberra, Melbourne, Sydney",
        "West Pacific Standard Time" to "(UTC+10:00) Guam, Port Moresby",
        "Tasmania Standard Time" to "(UTC+10:00) Hobart",
        "Vladivostok Standard Time" to "(UTC+10:00) Vladivostok",
        "Bougainville Standard Time" to "(UTC+11:00) Bougainville Island",
        "Magadan Standard Time" to "(UTC+11:00) Magadan",
        "Sakhalin Standard Time" to "(UTC+11:00) Sakhalin",
        "Lord Howe Standard Time" to "(UTC+10:30) Lord Howe Island",
        "Russia Time Zone 10" to "(UTC+11:00) Chokurdakh",
        "Norfolk Standard Time" to "(UTC+11:00) Norfolk Island",
        "Central Pacific Standard Time" to "(UTC+11:00) Solomon Is., New Caledonia",
        "Russia Time Zone 11" to "(UTC+12:00) Anadyr, Petropavlovsk-Kamchatsky",
        "New Zealand Standard Time" to "(UTC+12:00) Auckland, Wellington",
        "UTC+12" to "(UTC+12:00) Coordinated Universal Time+12",
        "Fiji Standard Time" to "(UTC+12:00) Fiji",
        "Kamchatka Standard Time" to "(UTC+12:00) Petropavlovsk-Kamchatsky - Old",
        "Chatham Islands Standard Time" to "(UTC+12:45) Chatham Islands",
        "UTC+13" to "(UTC+13:00) Coordinated Universal Time+13",
        "Tonga Standard Time" to "(UTC+13:00) Nuku'alofa",
        "Line Islands Standard Time" to "(UTC+14:00) Kiritimati Island"
)
