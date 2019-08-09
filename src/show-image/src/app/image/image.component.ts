import { Component, OnInit } from '@angular/core';
import {HttpImageService} from "../http/http-image.service";

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css']
})
export class ImageComponent implements OnInit {

  public imageUrl: string = 'api/';
  public ids: number[] = [];

  constructor(private httpImageService: HttpImageService) { }

  ngOnInit() {
    this.httpImageService.getIds().subscribe(data => this.ids = data);
    this.imageUrl = this.httpImageService.baseUrl;
  }

}
