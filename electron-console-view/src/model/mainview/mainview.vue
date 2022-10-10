<template>
    <!-- main -->
        <!--  queryform -->
    <div class="main-page">
        <div class="filter-input" v-if ="queryFormModel.isUser">
                <div v-for="(item , index) in queryFormModel.dataModeBehavior" :key="index">
                        
                        <div class="filter-input" v-if="item.__type === 'input' && item.__isHide == false">
                                <span>{{item.__title}}：</span>
                                <el-input v-model="queryFormModel.formData[item.__key]" class="real-input" size="small" />
                        </div>
                        <div class="filter-input" v-if="item.__type === 'selects' && item.__isHide == false">
                                <span>{{item.__title}}：</span>
                                <el-select v-model="queryFormModel.formData[item.__key]">
                                        <el-option  v-for="(selectValue , index) in item.__values" :key="index"  :label="selectValue.label"  :value="selectValue.value"  />
                                </el-select>
                        </div>
                </div>
        </div>
        <el-button @click="queryFormModel.request" type="primary" size="small">查询</el-button>
        <el-button @click="addModel.isVisible = true" type="primary" size="small">添加</el-button>
        <!--  table -->
        <el-table :data="tableView.__columnsData"  style="width: 100%">
                <el-table-column  v-for="(conmns , index) in tableView.__columns"  :prop="conmns.key" :label="conmns.title" width="300" />
                <el-table-column fixed="right" label="操作"  width="100">
                        <template slot-scope="scope">
                                <el-button v-if="queryModel.isUser"    @click="queryModel.showView(scope.row)"     type="text" size="small">查看</el-button>
                                <el-button v-if="updateModel.isUser" @click="updateModel.showView(scope.row)"   type="text" size="small">编辑</el-button>
                                <el-button v-if="tableView.deleteView(scope.row)" type="text" size="small">作废</el-button>
                                <el-button v-if="tableView.activationView(scope.row)" type="text" size="small">激活</el-button>
                        </template>
                </el-table-column>
        </el-table>
        <el-pagination background layout="prev, pager, next" 
                current-change="queryFormModel.request" 
                :page-size="tableView.__pagination.pageSize" 
                :current-page="tableView.__pagination.currentPage"
                 :total="tableView.__pagination.total" />
        <!--  add -->
        <Drawer title="添加" :model="addModel" :direction="direction" />
        <!--  update -->
        <Drawer title="修改" :model="updateModel" :direction="direction" />
        <!--  query -->
         <Details title="详情" v-if="slaveModel != null" :mode="queryModel" :direction="direction" size="80%"  >
               <Drawer slot="drawer" v-if="slaveModel != null" title="添加" :model="slaveModel.addModel" :direction="direction" :append="true" />
               <el-col :span="16" v-if="slaveModel != null" slot="col">
                                <div class="filter-input">
                                        <div v-for="(item , index) in slaveModel.queryFormModel.dataModeBehavior" :key="index">
                        
                                                <div class="filter-input" v-if="item.__type === 'input' && item.__isHide == false">
                                                        <span>{{item.__title}}：</span>
                                                        <el-input v-model="slaveModel.queryFormModel.formData[item.__key]" class="real-input" size="small" />
                                                </div>
                                                <div class="filter-input" v-if="item.__type === 'selects' && item.__isHide == false">
                                                        <span>{{item.__title}}：</span>
                                                        <el-select v-model="slaveModel.queryFormModel.formData[item.__key]">
                                                                <el-option  v-for="(selectValue , index) in item.__values" :key="index"  :label="selectValue.label"  :value="selectValue.value"  />
                                                        </el-select>
                                                </div>
                                        </div>
                                </div>
                                <el-button @click="slaveModel.queryFormModel.request" type="primary" size="small">查询</el-button>
                                <el-button @click="slaveModel.addModel.isVisible = true" type="primary" size="small">添加</el-button>
                                <!--  table -->
                                <el-table :data="slaveModel.tableView.__columnsData"  style="width: 100%">
                                        <el-table-column  v-for="(conmns , index) in slaveModel.tableView.__columns"  :prop="conmns.key" :label="conmns.title" width="300" />
                                        <el-table-column fixed="right" label="操作"  width="100">
                                                <template slot-scope="scope">
                                                        <el-button v-if="slaveModel.queryModel.isUser"    @click="slaveModel.queryModel.showView(scope.row)"     type="text" size="small">查看</el-button>
                                                        <el-button v-if="slaveModel.updateModel.isUser" @click="slaveModel.updateModel.showView(scope.row)"   type="text" size="small">编辑</el-button>
                                                        <el-button v-if="slaveModel.tableView.deleteView(scope.row)" type="text" size="small">作废</el-button>
                                                        <el-button v-if="slaveModel.tableView.activationView(scope.row)" type="text" size="small">激活</el-button>
                                                </template>
                                        </el-table-column>
                                </el-table>
                        </el-col>
         </Details>
        <Details title="子项详情" v-if="slaveModel != null" :mode="slaveModel.queryModel" :direction="direction" size="30%"  />
        </div>
</template>

<script>

import modelManage from "../modelManage"
import Drawer from './components/Drawer.vue'
import Details from "./components/Details.vue"
var viewModel = null;
//
export default {
        props: {
                info: {
                        type: Object,
                        default: null
                },
                view: {
                        type: Object,
                        default: null
                }
        },
        beforeCreate(){
             
        },
        data() {
           viewModel = modelManage.getViewModel(this);
           viewModel.setViewContextData("info", this.info);
           viewModel.setViewContextData("view",this.view);
           viewModel.tableView.__columnsData = [];
           viewModel.initialization();
           viewModel["direction"] = "rtl";
           return viewModel;
        },
        components:{
                Drawer,
                Details
        },
        mounted() {
                this.queryFormModel.request();
        },
        methods: {
                
        }
}

</script>