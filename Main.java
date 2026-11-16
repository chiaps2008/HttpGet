//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    String query = "https://api.openweathermap.org/data/2.5/weather?q=Parma,it&appid=ec4165dfd938247e677247252c24e155";
    String host = "api.openweathermap.org";
    String json = "";

    HttpGet httpGet = new HttpGet(query, host);
    int status;

    if( (status = httpGet.esegui()) == 200){
        json = httpGet.getData();
        System.out.println(json);
    }
    else{
        System.err.println("OPS Qualcosa è andato storto! " + status);
    }
}

