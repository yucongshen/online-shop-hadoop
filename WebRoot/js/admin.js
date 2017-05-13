$(function () {
	var treeData=[{
		text:"系统菜单",
		iconCls:"icon-system",
		children:
		[
			{
				text:"用户管理",
				iconCls:"icon-manager",
				children:
				[
					{
						text:"用户-列表",
						iconCls:"icon-user",
						attributes : 
						{
							url : "userManage_list.action?page=1"
						}
					}
				]
			},
			{
				text:"商品分类管理",
				iconCls:"icon-manager",
				children:
				[
				 	{
				 		text:"一级分类管理",
				 		iconCls:"icon-manager",
						children:
						[
							{
								text:"一级-列表",
								iconCls:"icon-edit-new",
								attributes : 
								{
									url : "firstCategoryManage_list.action?page=1"
								}
							},
							{
								text:"一级-添加",
								iconCls:"icon-add-new",
								attributes:
								{
									url:"admin/firstcategory/add.jsp"
								}
							}
						]
				 	},
				 	{
						text:"二级分类管理",
						iconCls:"icon-manager",
						children:
						[
							{
								text:"二级-列表",
								iconCls:"icon-edit-new",
								attributes:
								{
									url:"secondCategoryManage_list.action?page=1"
								}
							},
							{
								text:"二级-添加",
								iconCls:"icon-add-new",
								attributes:
								{
									url:"secondCategoryManage_addPage.action"
								}
							}
						]
					}
				]
			},
			
			{
				text:"商品管理",
				iconCls:"icon-manager",
				children:
				[
					{
						text:"商品-列表",
						iconCls:"icon-edit-new",
						attributes:
						{
							url:"productManage_list.action?page=1"
						}
					},
					{
						text:"商品-添加",
						iconCls:"icon-add-new",
						attributes:
						{
							url:"productManage_addPage.action"
						}
					}
				]
			},
			{
				text:"订单管理",
				iconCls:"icon-manager",
				children:
				[
					{
						text:"订单管理",
						iconCls:"icon-edit-new",
						attributes:
						{
							url:"orderManage_findOrderList.action?page=1"
						}
					}
				]
			},
			{
				text:"留言管理",
				iconCls:"icon-manager",
				children:
				[
					{
						text:"留言管理",
						iconCls:"icon-edit-new",
						attributes:
						{
							url:"messageManage_list.action?page=1"
						}
					}
				]
			},
			
		]	
	}];
    
    //实例化树形菜单
    $("#tree").tree({
        data : treeData,
        lines : true,
        onClick : function (node) {
            if (node.attributes) {
                Open(node.text, node.attributes.url);
            }
        }
    });
	//在右边center区域打开菜单，新增tab
    function Open(text, url) {
        if ($("#tabs").tabs('exists', text)) {
            $('#tabs').tabs('select', text);
        } else {
			var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';  
            $('#tabs').tabs('add', {
                title : text,
                closable : true,
                content :  content
            });
        }
    }
	//绑定tabs的右键菜单
    $("#tabs").tabs({
        onContextMenu : function (e, title) {
            e.preventDefault();
            $('#tabsMenu').menu('show', {
                left : e.pageX,
                top : e.pageY
            }).data("tabTitle", title);
        }
    });
    
    //实例化menu的onClick事件
    $("#tabsMenu").menu({
        onClick : function (item) {
            CloseTab(this, item.name);
        }
    });
    
    //几个关闭事件的实现
    function CloseTab(menu, type) {
        var curTabTitle = $(menu).data("tabTitle");
        var tabs = $("#tabs");
        
        if (type === "close") {
            tabs.tabs("close", curTabTitle);
            return;
        }
        
        var allTabs = tabs.tabs("tabs");
        var closeTabsTitle = [];
        
        $.each(allTabs, function () {
            var opt = $(this).panel("options");
            if (opt.closable && opt.title != curTabTitle && type === "Other") {
                closeTabsTitle.push(opt.title);
            } else if (opt.closable && type === "All") {
                closeTabsTitle.push(opt.title);
            }
        });
        
        for (var i = 0; i < closeTabsTitle.length; i++) {
            tabs.tabs("close", closeTabsTitle[i]);
        }
    }
});