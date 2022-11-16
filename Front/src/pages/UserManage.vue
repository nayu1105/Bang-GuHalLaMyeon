<template>
  <div>
    <Header headerShadow="header__area header__padding header__padding-2 header__shadow " />
    <UserManageArea />
    <Footer footerPadding="true" />
  </div>
</template>

<script>
import Header from "@/components/Home/Header.vue";
import UserManageArea from "@/components/UserManage/UserManageArea.vue";
import Footer from "@/components/Home/Footer.vue";

export default {
  name: "UserManage",
  components: {
    Header,
    UserManageArea,
    Footer,
  },
};
</script>
