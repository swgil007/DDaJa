<template>
    <div>
        <header />
        <slot />
        <footer />
    </div>
</template>

<script>
import Header from './components/Header';
import Footer from './components/Footer';

export default {
    name: 'Layout',
    components: {
        Header,
        Footer,
    },
}
</script>