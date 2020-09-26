import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from '../book.service';
import { VolumeInfo } from '../model/attribute';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  volinfo:VolumeInfo[]=[];
  constructor(private bookService:BookService, private router:Router) { }
  bcategory:string;
  show:boolean=false;
  ngOnInit(): void {
  }

  public dispCategoryBooks(category:string){
    
    console.log("inside dispbooks");
    this.bcategory=category;
    this.bookService.displayCategoryBooks(category).subscribe(data=>{
      console.log(data.items.length);
      for(let i in data.items)
      {
        let item=data.items[i];
        
        this.volinfo.push(item.volumeInfo);
        console.log("Volume info"+i);
        console.log(this.volinfo);
        
      }
      this.show=true;
    });
    
    this.router.navigate(['category']);
    this.show=false;
    
  }


}
