
$(document).ready(function() {
    $('#convert').click(function () {
        var json = JSON.parse($('#json').val());
        var jsonArray = json['content']['content'];
        var type = "";
        var xml = "";
        jsonArray.forEach(function(row) {
            if (!row['attrs']) {
                if (row['content'][1]) {
                    type = row['content'][1]['content']['text'];
                    type = type.replace('Aanvallers', 'aanvaller');
                    type = type.replace('Middenvelders', 'middenvelder');
                    type = type.replace('Verdedigers', 'verdediger');
                    type = type.replace('Keepers', 'keeper');
                }
            }
            else {
                xml += "<speler>";
                xml += "<naam>"+ row['content'][2]['content']['content']['text'] +"</naam>";
                xml += "<type>"+ type +"</type>";
                if (type != 'keeper') {
                    xml += "<aanval>"+ row['content'][3]['content']['text'] +"</aanval>";
                    xml += "<verdediging>"+ row['content'][4]['content']['text'] +"</verdediging>";
                }
                else {
                    xml += "<keeperskills>"+ row['content'][4]['content']['text'] +"</keeperskills>";
                }
                xml += "<conditie>100</conditie>";
                xml += "<agressie>hoog</agressie>";
                xml += "<status>groen</status>";
                xml += "<leeftijd>"+ row['content'][9]['content']['text'] +"</leeftijd>";
                xml += "<land>"+ row['content'][1]['content']['attrs']['title'] +"</land>";
                if (row['content'][11]['content']['text']) {
                    var prijs = row['content'][11]['content']['text'];
                }
                else {
                    var prijs = row['content'][11]['content']['content']['content']['text'];
                }
                xml += "<prijs>"+ prijs.replace(/\D/g,'') +"</prijs>";
                xml += "</speler>";
            }
        });
        var teamnaam = $('#teamnaam').val();
        var geld = $('#geld').val();
        $('#xml').val("<team><teamnaam>"+ teamnaam +"</teamnaam><geld>"+ geld +"</geld><spelers>"+ xml +"</spelers></team>");
    });
});

