$(function(){

	function setMyForm(target){

		var ERROR_MESSAGE_CLASSNAME = 'errorMsg'; //エラー時のメッセージ要素のclass名
		var ERROR_INPUT_CLASSNAME = 'errorInput'; //エラー時のinput要素のclass名

		var items = []; //チェック対象となるテキスト入力要素を格納した配列
		var addressObj; //チェック対象となるselect要素のセレクタを格納した変数
		var genreObj; //チェック対象となるcheckbox要素のセレクタを格納した変数

		//項目チェックする
		function checkAll(){
			var errorCount = 0;
			//input,textareaのチェック
			for( var i=0; i<items.length; i++ ){
				if( items[i].prop('isSuccess') == false ){
					errorCount++;
				};
			};
			//エラーカウントが0であれば、エラー無し
			if( errorCount == 0 ){
				target.find('input[type=submit]').attr('disabled', false);
			}else{
				target.find('input[type=submit]').attr('disabled', true);
			};
		};

		//エラーメッセージの追加
		function addErrorMessage(selector, msg){
			removeErrorMessage(selector);
			selector.before('<span class="'+ERROR_MESSAGE_CLASSNAME+'">'+msg+'</span>');
			selector.addClass(ERROR_INPUT_CLASSNAME);
		};

		//エラーメッセージの削除
		function removeErrorMessage(selector){
			var msgSelector = selector.parent().find('.'+ERROR_MESSAGE_CLASSNAME);
			if( msgSelector.length != 0 ){
				msgSelector.remove();
				selector.removeClass(ERROR_INPUT_CLASSNAME);
			};
		};

		//input,textareaの未入力チェック
		function checkEmptyText(selector, msg){
			if( selector.val() == '' ){
				addErrorMessage(selector, msg);
				selector.prop('isSuccess', false);
			}else{
				removeErrorMessage(selector);
				selector.prop('isSuccess', true);
			};
		};

		//inputのフォーマットチェック
		function checkFormatText(selector, mode, msg){
			var value = selector.val();
			switch(mode){
				//全角チェック
				case 0:
					if(value.match(/^[^ -~｡-ﾟ]*$/)){
						selector.prop('isSuccess', true);
					}else{
						selector.prop('isSuccess', false);
					};
					break;
				//ふりがなのみ
				case 1:
					if(value.match(/^[\u3040-\u309F]+$/)){
						selector.prop('isSuccess', true);
					}else{
						selector.prop('isSuccess', false);
					};
					break;
				//半角数字のみ
				case 2:
					if(value.match(/^[0-9]*$/)){
						selector.prop('isSuccess', true);
					}else{
						selector.prop('isSuccess', false);
					};
					break;
				//メールアドレス
				case 3:
					if(value.match(/^[a-zA-Z0-9!$&*.=^`|~#%'+\/?_{}-]+@([a-zA-Z0-9_-]+\.)+[a-zA-Z]{2,6}$/)){
						selector.prop('isSuccess', true);
					}else{
						selector.prop('isSuccess', false);
					};
					break;
					//半角英数字
					case 4:
						if(value.match(/^[a-zA-Z0-9]+$/)){
							selector.prop('isSuccess', true);
						}else{
							selector.prop('isSuccess', false);
						};
						break;
			};
			if( selector.prop('isSuccess') == false ){
				addErrorMessage(selector, msg);
			}else{
				removeErrorMessage(selector);
			};
		};

		//初期設定
		function init(){
			//submitを無効にする
			target.find('input[type=submit]').attr('disabled', true);
			//submitイベントの設定
			target.on({
				'submit': function(){
					return false;
				}
			});
			//input要素を配列に格納
			items = [
				target.find('input[name=user_name]'),
				target.find('input[name=user_pass]'),
				target.find('input[name=com_name]'),
				target.find('input[name=com_department]'),
				target.find('input[name=user_tel]'),
				target.find('input[name=user_fax]'),
				target.find('input[name=user_address]'),
			];
			//input要素のプロパティを設定
			$.each(items, function(index){
				items[index].prop('isSuccess', false);
			});
			//enterキーでsubmitしてしまうのを防止する
			target.find('input[type=text]').on({
				'keypress': function(e){
					if( (e.keyCode == 13) ) return false;
				}
			});
			//名前
			items[0].on({
				'blur': function(){
					checkEmptyText( $(this), '名前をご入力ください。' );
					if( $(this).prop('isSuccess') ) checkFormatText( $(this), 0, '入力フォーマットが正しくありません。' );
					checkAll();
				}
			});
			//パスワード
			items[1].on({
				'blur': function(){
					checkEmptyText( $(this), 'パスワードをご入力ください。' );
					if( $(this).prop('isSuccess') ) checkFormatText( $(this), 4, '入力フォーマットが正しくありません。' );
					checkAll();
				}
			});
			//会社名
			items[2].on({
				'blur': function(){
					checkEmptyText( $(this), '会社名をご入力ください。' );
					checkAll();
				}
			});
			//部署名
			items[3].on({
				'blur': function(){
					checkEmptyText( $(this), '部署名をご入力ください。' );
					checkAll();
				}
			});
			//電話番号
			items[4].on({
				'blur': function(){
					checkEmptyText( $(this), '電話番号をご入力ください。' );
					if( $(this).prop('isSuccess') ) checkFormatText( $(this), 2, '入力フォーマットが正しくありません。' );
					checkAll();
				}
			});
			//FAX
			items[5].on({
				'blur': function(){
					checkEmptyText( $(this), 'FAXをご入力ください。' );
					if( $(this).prop('isSuccess') ) checkFormatText( $(this), 2, '入力フォーマットが正しくありません。' );
					checkAll();
				}
			});
			//住所
			items[6].on({
				'blur': function(){
					checkEmptyText( $(this), '住所をご入力ください。' );
					checkAll();
				}
			});
		};

		init();

	};

	setMyForm($('#myForm'));

});
