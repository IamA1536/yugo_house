function newDecorate() {
    $('#dlg').dialog('open').dialog('setTitle','添加用户');
    $('#fm').form('clear');
    url = 'new_decorate';
}

function editDecorate() {
    var row = $('#dg').datagrid('getSelected');
    if (row){
        $('#dlg').dialog('open').dialog('setTitle','Edit Building');
        $('#fm').form('load',row);
        // document.getElementsByName('pw').setAttribute("readOnly",'true');
        // $('[name="pw"]').attr('readOnly','readonly');
        url = 'update_decorate?id='+row.id;
    }
}

function destroyDecorate() {
    var row = $('#dg').datagrid('getSelected');
    if (row){
        $.messager.confirm('Confirm','Are you sure you want to destroy this building?',function(r){
            if (r){
                $.post('destroy_decorate',{ID:row.ID},function(result){
                    if (result.success){
                        $('#dg').datagrid('reload');	// reload the user data
                    } else {
                        $.messager.show({	// show error message
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    }
                },'json');
            }
        });
    }
}

function saveDecorate() {
    $('#fm').form('submit',{
        url: url,
        onSubmit: function(){
            return $(this).form('validate');
        },
        success: function(result){
            var result = eval('('+result+')');
            if (result.errorMsg){
                $.messager.show({
                    title: 'Error',
                    msg: result.errorMsg
                });
            } else {
                $('#dlg').dialog('close');		// close the dialog
                $('#dg').datagrid('reload');	// reload the user data
            }
        }
    });
}
