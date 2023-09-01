import requests

requisicao = requests.get("https://cep.awesomeapi.com.br/json/58434140")
dados_json = requisicao.json()

cep = dados_json['cep']
nomeEndereco = dados_json['address_name']
estado = dados_json['state']
bairro = dados_json['district']
latitude = dados_json['lat']
longitude = dados_json['lng']
cidade = dados_json['city']

info_json = {
    "cep": cep,
    "address_name": nomeEndereco,
    "state": estado,
    "district": bairro,
    "lat": latitude,
    "lng": longitude,
    "city": cidade
}

print(info_json)
