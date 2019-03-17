angular.module("ProductApp").service("productService",function($http){
	this.getProducts=function(){
		return $http.get("/api/products");
	};
	
	this.saveProduct=function(product,file){
 	   var fd=new FormData();
 	   fd.append("image",file);
 	   for(key in product){
 		   fd.append(key,product[key]);
 	   }
 	  return $http.post("/api/products",fd,{
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        });
    };
    
    this.delete=function(productId){
    	return $http.delete("/api/products/"+productId);
    }
    
    this.getProduct=function(productId){
    	return $http.get("/api/products/"+productId);
    }
    
    this.update=function(product){
    	return $http.put("/api/products",product);
    }
    
});