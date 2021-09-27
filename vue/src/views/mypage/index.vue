<template>
  <div>
    <el-container>
      <el-aside>
        <el-menu :default-openeds="['1']">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message" />Navigator One</template>
            <el-menu-item-group>
              <template slot="title">Group 1</template>
              <el-menu-item index="1-1">Option 1</el-menu-item>
              <el-menu-item index="1-2">Option 2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group 2">
              <el-menu-item index="1-3">Option 3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">Option4</template>
              <el-menu-item index="1-4-1">Option 4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu" />Navigator Two</template>
            <el-menu-item-group>
              <template slot="title">Group 1</template>
              <el-menu-item index="2-1">Option 1</el-menu-item>
              <el-menu-item index="2-2">Option 2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group 2">
              <el-menu-item index="2-3">Option 3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="2-4">
              <template slot="title">Option 4</template>
              <el-menu-item index="2-4-1">Option 4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting" />Navigator Three</template>
            <el-menu-item-group>
              <template slot="title">Group 1</template>
              <el-menu-item index="3-1">Option 1</el-menu-item>
              <el-menu-item index="3-2">Option 2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group 2">
              <el-menu-item index="3-3">Option 3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="3-4">
              <template slot="title">Option 4</template>
              <el-menu-item index="3-4-1">Option 4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header>
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px" />
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>View</el-dropdown-item>
              <el-dropdown-item>Add</el-dropdown-item>
              <el-dropdown-item>Delete</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>Tom</span>
        </el-header>

        <el-main>
          <el-table :data="tableData">
            <el-table-column prop="date" label="Date" width="140" />
            <el-table-column prop="name" label="Name" width="120" />
            <el-table-column prop="address" label="Address" />
          </el-table>
          <user-info-form />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import userInfoForm from './components/userInfoForm.vue'
export default {
  components: {
    userInfoForm
  },
  data() {
    const item = {
      date: '2016-05-02',
      name: 'Tom',
      address: 'No. 189, Grove St, Los Angeles'
    }
    return {
      tableData: Array(20).fill(item)
    }
  }
}
</script>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
    text-align: right;
    font-size: 12px;
  }
  .el-aside {
    color: #333;
    background-color: rgb(238, 241, 246);
    width: 100px;
  }
  .el-container {
      height: 100%;
      border: 1px solid #eee;
  }
</style>
