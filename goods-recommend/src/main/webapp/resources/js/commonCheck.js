/**
 * 
 */
		
		
		
		
		/**
			<input onkeyup="keyUpCheckNum(this)" onblur="blurCheckNum(this)" value="" id="" name="">
		*/
		function keyUpCheckNum(ele){
			var tag=/^\d+\.{0,1}(\d{1,2}){0,1}$/;
			var val=$(ele).val();
			if(tag.test(val)==false){
				var str = val.substring(0,val.length-1);
				$(ele).val(str);
				return false;
			}else{
				return true;
			}
		}
		
		function blurCheckNum(ele){
			var tag=/^\d+\.{0,1}(\d{1,2}){0,1}$/;
			var val=$(ele).val();
			if(tag.test(val)==false){
				$(ele).val("");
				return false;
			}else{
				return true;
			}
		}
		
		
		function keyUpCheckNum4(ele){
			var tag=/^\d+\.{0,1}(\d{1,4}){0,1}$/;
			var val=$(ele).val();
			if(tag.test(val)==false){
				var str = val.substring(0,val.length-1);
				$(ele).val(str);
				return false;
			}else{
				return true;
			}
		}
		
		function blurCheckNum4(ele){
			var tag=/^\d+\.{0,1}(\d{1,4}){0,1}$/;
			var val=$(ele).val();
			if(tag.test(val)==false){
				$(ele).val("");
				return false;
			}else{
				return true;
			}
		}
		
		