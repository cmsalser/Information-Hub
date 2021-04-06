import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-information-page',
  templateUrl: './information-page.component.html',
  styleUrls: ['./information-page.component.css']
})
export class InformationPageComponent implements OnInit {
  pdfs = [
    {title: "Alcohol-(CLDF)", src: "assets/pdfs/Alcohol-(CLDF).pdf"},
    {title: "Alcohol-&-You-teen-guide-(UK 2015)", src: "assets/pdfs/Alcohol-&-You-teen-guide-(UK 2015).pdf"},
    {title: "Alcohol-and-young-people-leaflet", src: "assets/pdfs/Alcohol-and-young-people-leaflet.pdf"},
    {title: "Alcohol-when-you-have-a-liver-disease-(CLDF-young-persons'-responses)", src: "assets/pdfs/Alcohol-when-you-have-a-liver-disease-(CLDF-young-persons'-responses).pdf"},
    {title: "Autoimmune-Liver-Disease-Day-February-2019-Summary1", src: "assets/pdfs/Autoimmune-Liver-Disease-Day-February-2019-Summary1.pdf"},
    {title: "Listen-Website", src: "assets/pdfs/Listen-Website.pdf"},
    {title: "Liver-transition-info", src: "assets/pdfs/Liver-transition-info.pdf"},
    {title: "LN-Information-from-clinic", src: "assets/pdfs/LN-Information-from-clinic.pdf"},
    {title: "Managing-My-Anger", src: "assets/pdfs/Managing-My-Anger.pdf"},
    {title: "Puberty-and-contraception", src: "assets/pdfs/Puberty-and-contraception.pdf"}
  ];
  pdfSource: "";

  constructor() { }

  ngOnInit(): void {
  }

  openFile() {
    window.open(this.pdfSource);
  }
}
