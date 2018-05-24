/**
 * 
 */
$(function(){
		$.ajax({
			url: './CommentList.ite',
			data: {
				c_board:$("#c_board").val()
			},
			success : function(data){
				$("#c_list").html(data);
			}
		});
		
		$(".okBtn").on("click", function() {
			
			if ($.trim($("#c_content").val()) == "") {
				alert('댓글을 입력해주세요.');
				$("#c_content").val("");
				$("#c_content").focus();
			} else {
				$.ajax({
					type : 'POST',
					url : './CommentWriteAction.ite',
					data : {
						c_name : $("#c_name").val(),
						c_content : $("#c_content").val(),
						c_board : $("#c_board").val()
					},
					success : function(data) {
						$("#c_list").html(data);
					}
				});
				$("#c_content").val("");
			}

		});
		
});	




