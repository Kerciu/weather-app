package main.java.frontend.utility;

public class CountryImageResolver {
    public static final String flagsPath = "assets/images/countries/";

    public static String getCountryImagePath(String countryName) {
        return switch (countryName.toLowerCase()) {
            case "albania" -> flagsPath + "albania.png";
            case "algeria" -> flagsPath + "algeria.png";
            case "andorra" -> flagsPath + "andorra.png";
            case "angola" -> flagsPath + "angola.png";
            case "antigua and barbuda" -> flagsPath + "antigua-and-barbuda.png";
            case "argentina" -> flagsPath + "argentina.png";
            case "armenia" -> flagsPath + "armenia.png";
            case "australia" -> flagsPath + "australia.png";
            case "austria" -> flagsPath + "austria.png";
            case "azerbaijan" -> flagsPath + "azerbaijan.png";
            case "bahamas" -> flagsPath + "bahamas.png";
            case "bahrain" -> flagsPath + "bahrain.png";
            case "bangladesh" -> flagsPath + "bangladesh.png";
            case "barbados" -> flagsPath + "barbados.png";
            case "belarus" -> flagsPath + "belarus.png";
            case "belgium" -> flagsPath + "belgium.png";
            case "belize" -> flagsPath + "belize.png";
            case "benin" -> flagsPath + "benin.png";
            case "bhutan" -> flagsPath + "bhutan.png";
            case "bolivia" -> flagsPath + "bolivia.png";
            case "bosnia and herzegovina" -> flagsPath + "bosnia-and-herzegovina.png";
            case "botswana" -> flagsPath + "botswana.png";
            case "brazil" -> flagsPath + "brazil.png";
            case "brunei" -> flagsPath + "brunei.png";
            case "bulgaria" -> flagsPath + "bulgaria.png";
            case "burkina faso" -> flagsPath + "burkina-faso.png";
            case "burundi" -> flagsPath + "burundi.png";
            case "cabo verde" -> flagsPath + "cabo-verde.png";
            case "cambodia" -> flagsPath + "cambodia.png";
            case "cameroon" -> flagsPath + "cameroon.png";
            case "canada" -> flagsPath + "canada.png";
            case "central african republic" -> flagsPath + "central-african-republic.png";
            case "chad" -> flagsPath + "chad.png";
            case "chile" -> flagsPath + "chile.png";
            case "china" -> flagsPath + "china.png";
            case "colombia" -> flagsPath + "colombia.png";
            case "comoros" -> flagsPath + "comoros.png";
            case "congo" -> flagsPath + "congo.png";
            case "costa rica" -> flagsPath + "costa-rica.png";
            case "croatia" -> flagsPath + "croatia.png";
            case "cuba" -> flagsPath + "cuba.png";
            case "cyprus" -> flagsPath + "cyprus.png";
            case "czech republic", "czechia" -> flagsPath + "czech-republic.png";
            case "denmark" -> flagsPath + "denmark.png";
            case "djibouti" -> flagsPath + "djibouti.png";
            case "dominica" -> flagsPath + "dominica.png";
            case "dominican republic" -> flagsPath + "dominican-republic.png";
            case "dr congo" -> flagsPath + "democratic-republic-of-congo.png";
            case "east timor" -> flagsPath + "east-timor.png";
            case "ecuador" -> flagsPath + "ecuador.png";
            case "egypt" -> flagsPath + "egypt.png";
            case "el salvador" -> flagsPath + "el-salvador.png";
            case "equatorial guinea" -> flagsPath + "equatorial-guinea.png";
            case "eritrea" -> flagsPath + "eritrea.png";
            case "estonia" -> flagsPath + "estonia.png";
            case "eswatini" -> flagsPath + "eswatini.png";
            case "ethiopia" -> flagsPath + "ethiopia.png";
            case "fiji" -> flagsPath + "fiji.png";
            case "finland" -> flagsPath + "finland.png";
            case "france" -> flagsPath + "france.png";
            case "gabon" -> flagsPath + "gabon.png";
            case "gambia" -> flagsPath + "gambia.png";
            case "georgia" -> flagsPath + "georgia.png";
            case "germany" -> flagsPath + "germany.png";
            case "ghana" -> flagsPath + "ghana.png";
            case "greece" -> flagsPath + "greece.png";
            case "grenada" -> flagsPath + "grenada.png";
            case "guatemala" -> flagsPath + "guatemala.png";
            case "guinea" -> flagsPath + "guinea.png";
            case "guinea-bissau" -> flagsPath + "guinea-bissau.png";
            case "guyana" -> flagsPath + "guyana.png";
            case "haiti" -> flagsPath + "haiti.png";
            case "honduras" -> flagsPath + "honduras.png";
            case "hungary" -> flagsPath + "hungary.png";
            case "iceland" -> flagsPath + "iceland.png";
            case "india" -> flagsPath + "india.png";
            case "indonesia" -> flagsPath + "indonesia.png";
            case "iran" -> flagsPath + "iran.png";
            case "iraq" -> flagsPath + "iraq.png";
            case "ireland" -> flagsPath + "ireland.png";
            case "israel" -> flagsPath + "israel.png";
            case "italy" -> flagsPath + "italy.png";
            case "jamaica" -> flagsPath + "jamaica.png";
            case "japan" -> flagsPath + "japan.png";
            case "jordan" -> flagsPath + "jordan.png";
            case "kazakhstan" -> flagsPath + "kazakhstan.png";
            case "kenya" -> flagsPath + "kenya.png";
            case "kiribati" -> flagsPath + "kiribati.png";
            case "korea" -> flagsPath + "korea.png";
            case "kosovo" -> flagsPath + "kosovo.png";
            case "kuwait" -> flagsPath + "kuwait.png";
            case "kyrgyzstan" -> flagsPath + "kyrgyzstan.png";
            case "laos" -> flagsPath + "laos.png";
            case "latvia" -> flagsPath + "latvia.png";
            case "lebanon" -> flagsPath + "lebanon.png";
            case "lesotho" -> flagsPath + "lesotho.png";
            case "liberia" -> flagsPath + "liberia.png";
            case "libya" -> flagsPath + "libya.png";
            case "liechtenstein" -> flagsPath + "liechtenstein.png";
            case "lithuania" -> flagsPath + "lithuania.png";
            case "luxembourg" -> flagsPath + "luxembourg.png";
            case "madagascar" -> flagsPath + "madagascar.png";
            case "malawi" -> flagsPath + "malawi.png";
            case "malaysia" -> flagsPath + "malaysia.png";
            case "maldives" -> flagsPath + "maldives.png";
            case "mali" -> flagsPath + "mali.png";
            case "malta" -> flagsPath + "malta.png";
            case "mauritania" -> flagsPath + "mauritania.png";
            case "mauritius" -> flagsPath + "mauritius.png";
            case "mexico" -> flagsPath + "mexico.png";
            case "micronesia" -> flagsPath + "micronesia.png";
            case "moldova" -> flagsPath + "moldova.png";
            case "monaco" -> flagsPath + "monaco.png";
            case "mongolia" -> flagsPath + "mongolia.png";
            case "morocco" -> flagsPath + "morocco.png";
            case "mozambique" -> flagsPath + "mozambique.png";
            case "myanmar" -> flagsPath + "myanmar.png";
            case "namibia" -> flagsPath + "namibia.png";
            case "nauru" -> flagsPath + "nauru.png";
            case "nepal" -> flagsPath + "nepal.png";
            case "netherlands" -> flagsPath + "netherlands.png";
            case "new zealand" -> flagsPath + "new-zealand.png";
            case "nicaragua" -> flagsPath + "nicaragua.png";
            case "niger" -> flagsPath + "niger.png";
            case "nigeria" -> flagsPath + "nigeria.png";
            case "north korea" -> flagsPath + "north-korea.png";
            case "north macedonia" -> flagsPath + "north-macedonia.png";
            case "norway" -> flagsPath + "norway.png";
            case "oman" -> flagsPath + "oman.png";
            case "pakistan" -> flagsPath + "pakistan.png";
            case "palau" -> flagsPath + "palau.png";
            case "panama" -> flagsPath + "panama.png";
            case "papua new guinea" -> flagsPath + "papua-new-guinea.png";
            case "paraguay" -> flagsPath + "paraguay.png";
            case "peru" -> flagsPath + "peru.png";
            case "philippines" -> flagsPath + "philippines.png";
            case "poland" -> flagsPath + "poland.png";
            case "portugal" -> flagsPath + "portugal.png";
            case "qatar" -> flagsPath + "qatar.png";
            case "romania" -> flagsPath + "romania.png";
            case "russia" -> flagsPath + "russia.png";
            case "rwanda" -> flagsPath + "rwanda.png";
            case "saint kitts and nevis" -> flagsPath + "saint-kitts-and-nevis.png";
            case "saint lucia" -> flagsPath + "saint-lucia.png";
            case "saint vincent and the grenadines" -> flagsPath + "saint-vincent-and-the-grenadines.png";
            case "samoa" -> flagsPath + "samoa.png";
            case "san marino" -> flagsPath + "san-marino.png";
            case "sao tome and principe" -> flagsPath + "sao-tome-and-principe.png";
            case "saudi arabia" -> flagsPath + "saudi-arabia.png";
            case "senegal" -> flagsPath + "senegal.png";
            case "serbia" -> flagsPath + "serbia.png";
            case "seychelles" -> flagsPath + "seychelles.png";
            case "sierra leone" -> flagsPath + "sierra-leone.png";
            case "singapore" -> flagsPath + "singapore.png";
            case "slovakia" -> flagsPath + "slovakia.png";
            case "slovenia" -> flagsPath + "slovenia.png";
            case "solomon islands" -> flagsPath + "solomon-islands.png";
            case "somalia" -> flagsPath + "somalia.png";
            case "south africa" -> flagsPath + "south-africa.png";
            case "south korea" -> flagsPath + "south-korea.png";
            case "south sudan" -> flagsPath + "south-sudan.png";
            case "spain" -> flagsPath + "spain.png";
            case "sri lanka" -> flagsPath + "sri-lanka.png";
            case "sudan" -> flagsPath + "sudan.png";
            case "suriname" -> flagsPath + "suriname.png";
            case "sweden" -> flagsPath + "sweden.png";
            case "switzerland" -> flagsPath + "switzerland.png";
            case "syria" -> flagsPath + "syria.png";
            case "taiwan" -> flagsPath + "taiwan.png";
            case "tajikistan" -> flagsPath + "tajikistan.png";
            case "tanzania" -> flagsPath + "tanzania.png";
            case "thailand" -> flagsPath + "thailand.png";
            case "togo" -> flagsPath + "togo.png";
            case "tonga" -> flagsPath + "tonga.png";
            case "trinidad and tobago" -> flagsPath + "trinidad-and-tobago.png";
            case "tunisia" -> flagsPath + "tunisia.png";
            case "turkey" -> flagsPath + "turkey.png";
            case "turkmenistan" -> flagsPath + "turkmenistan.png";
            case "tuvalu" -> flagsPath + "tuvalu.png";
            case "uganda" -> flagsPath + "uganda.png";
            case "ukraine" -> flagsPath + "ukraine.png";
            case "united arab emirates" -> flagsPath + "united-arab-emirates.png";
            case "united kingdom" -> flagsPath + "united-kingdom.png";
            case "united states" -> flagsPath + "united-states.png";
            case "uruguay" -> flagsPath + "uruguay.png";
            case "uzbekistan" -> flagsPath + "uzbekistan.png";
            case "vanuatu" -> flagsPath + "vanuatu.png";
            case "venezuela" -> flagsPath + "venezuela.png";
            case "vietnam" -> flagsPath + "vietnam.png";
            case "yemen" -> flagsPath + "yemen.png";
            case "zambia" -> flagsPath + "zambia.png";
            case "zimbabwe" -> flagsPath + "zimbabwe.png";
            default -> flagsPath + "poland.png";
        };
    }
}
